var user = {
    login: "exampleUser",
    password: "examplePassword"
};

// Создаем настройки для запроса
var requestOptions = {
    method: 'POST', // Метод запроса
    headers: {
        'Content-Type': 'application/json' // Устанавливаем заголовок Content-Type
    },
    body: JSON.stringify(user) // Преобразуем объект в JSON и передаем его в теле запроса
};

// Отправляем запрос на сервер
fetch('/api/v1/users/sign', requestOptions)
    .then(response => response.text()) // Получаем текстовый ответ
    .then(data => {
        // Обрабатываем ответ от сервера
        console.log(data);
    })
    .catch(error => {
        // Обрабатываем ошибки
        console.error('Ошибка:', error);
    });