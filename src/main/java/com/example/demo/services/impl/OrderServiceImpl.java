package com.example.demo.services.impl;

import com.example.demo.models.Orders;
import com.example.demo.repos.OrderRepo;
import com.example.demo.repos.PriceRepo;
import com.example.demo.repos.ClientRepo;
import com.example.demo.services.MailSenderService;
import com.example.demo.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.time.LocalDate;
import java.util.Arrays;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final PriceRepo priceRepo;
    private final MailSenderService mailSenderService;
    private final ClientRepo clientRepo;


    public OrderServiceImpl(OrderRepo orderRepo, PriceRepo priceRepo, MailSenderService mailSenderService, ClientRepo clientRepo) {
        this.orderRepo = orderRepo;
        this.priceRepo = priceRepo;
        this.mailSenderService = mailSenderService;
        this.clientRepo = clientRepo;
    }
    @Override
    public ResponseEntity<?> createOrder(Orders orders) {
        if (orders.getDates().stream().allMatch(o -> o.isBefore(LocalDate.now()))){
            throw new RuntimeException("Incorrect date!");
        }

        orders.setPrice(priceRepo.priceFinder(orders.getPrice().getCar().getId()));
        orders.setDate(LocalDate.now());
        orders.setSum(orders.getDates().size()* orders.getPrice().getPrice());
        orders.setCar(orders.getPrice().getCar());
        orders.setClient(clientRepo.findById(orders.getClient().getId()));
        String email = orders.getClient().getUserEmail();
        String url = orders.getPrice().getCar().getImageUrl();
        String msgText = "Order info: " +
                "\nChosen car is " + orders.getCar().getManufacturer().getName() + " " +
                orders.getCar().getName() + "\nFor dates " + Arrays.toString(orders.getDates().toArray()) + "\nFinal price is - "+
                orders.getPrice().getPrice() + " USD";
        try {
            mailSenderService.sendMail(email,url,msgText);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(orderRepo.save(orders));
    }
}
