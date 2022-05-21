# web-services

*Лабораторные работы по дисциплине "Технологии Веб сервисов"*

---
---

### Лабораторная работа 1

*Задание*

В данной работе требуется создать таблицу в базе данных, содержащую не менее пяти полей, а также реализовать возможность
поиска по любым комбинациям полей с помощью SOAP-сервиса. Данные для поиска должны передаваться в метод сервиса в
качестве аргументов.

Веб-сервис необходимо реализовать в виде standalone-приложения и J2EE- приложения. При реализации в виде J2EE-приложения
следует на стороне сервера приложений настроить источник данных и осуществлять его инъекцию в коде сервиса.

Для демонстрации работы разработанных сервисов следует также разработать и клиентское консольное приложение.

[*Исходный код*](https://github.com/AnastasiyaSmirnova/web-services/tree/laboratory-work-1)

[*Скрипты для работы с Базой данных*](https://github.com/AnastasiyaSmirnova/web-services/tree/laboratory-work-1/sql)

*Структура проекта*

1. Standalone-application
    * model
        * Book
    * dao
        * *Executor*
        * BookDao
    * service
        * BookService
    * StandaloneApplication ( main() )
    * ConnectionUtil (connection to DB)


2. Java EE application ( Glassfish )
    * model
        * Book
    * dao
        * Executor
        * BookDao
    * service
        * BookService <= DataSource ("jdbc/ifmo-ws")

---
---

### Лабраторная работа 2

*Задание*

В данной работе в веб-сервис, разработанный в первой работе, необходимо добавить методы для создания, изменения и
удаления записей из таблицы.

Метод создания должен принимать значения полей новой записи, метод изменения – идентификатор изменяемой записи, а также
новые значения полей, а метод удаления – только идентификатор удаляемой записи.

Метод создания должен возвращать идентификатор новой записи, а методы обновления или удаления – статус операции. В
данной работе следует вносить изменения только в standalone-реализацию сервиса.

В соответствии с изменениями сервиса необходимо обновить и клиентское приложение.

[*Исходный код*](https://github.com/AnastasiyaSmirnova/web-services/tree/laboratory-work-2)


---
---

### Лабораторная работа 3

*Задание*

Основываясь на информации из раздела 2.8, добавить поддержку обработки ошибок в сервис. Возможные ошибки, которые могут
происходить при добавлении, изменении или удалении записей: неверное значение одного из полей; попытка изменить или
удалить несуществующую запись.

В соответствии с изменениями сервиса необходимо обновить и клиентское приложение.

[*Исходный код*](https://github.com/AnastasiyaSmirnova/web-services/tree/laboratory-work-3)

[*класс
IllegalParameterException*](https://github.com/AnastasiyaSmirnova/web-services/blob/laboratory-work-3/standalone-application/src/main/java/itmo/web_services/exception/IllegalParameterException.java)

[*класс
BookServiceFault*](https://github.com/AnastasiyaSmirnova/web-services/blob/laboratory-work-3/standalone-application/src/main/java/itmo/web_services/exception/BookServiceFault.java)

*Измененная структура проекта:*

* model
    * Book
    * dao
        * *Executor*
        * BookDao
    * service
        * BookService
    * **exception**
        * IllegalParameterException
        * BookServiceFault
    * StandaloneApplication ( main() )
    * ConnectionUtil (connection to DB)

      Использовались 2 изображения

---

##### Дополнительное задание I: Обработка бинарных данных.

Реализованы 2 метода передачи изображений:

* send image as String
* send image as attachment

[Обновленный BookService](https://github.com/AnastasiyaSmirnova/web-services/blob/laboratory-work-3-improvements/standalone-application/src/main/java/itmo/web_services/service/BooksWebService.java)

[Вспомогательный класс ImageUtils](https://github.com/AnastasiyaSmirnova/web-services/blob/laboratory-work-3-improvements/standalone-application/src/main/java/itmo/web_services/ImageUtils.java)

В результате выполнения запросов клиентом были получены следующие изображения:

[Певрое прочитанное клиентом изображение](https://github.com/AnastasiyaSmirnova/web-services/blob/laboratory-work-3-improvements/soap-client/image_as_string.jpg)

[Второе прочитанное клиентом изображение](https://github.com/AnastasiyaSmirnova/web-services/blob/laboratory-work-3-improvements/soap-client/image_as_attachment.jpg)

---

##### Дополнительное задание II: thread-safe JAX-WS client.

Согласно [*докуметации*](https://cxf.apache.org/faq.html#FAQ-AreJAX-WSclientproxiesthreadsafe?) JAX-WS клиенты не
являются потобезпасными:

``` 
Official JAX-WS answer: 
No. According to the JAX-WS spec, 
the client proxies are NOT thread safe. 
To write portable code, you should treat them as non-thread safe
and synchronize access or use a pool of instances or similar.
```

Для решения проблемы в программе используются [*ассинхронные
вызовы*](https://github.com/AnastasiyaSmirnova/web-services/blob/9b651b94ff2031c19d99a27f3cc14c5ea77c6010/soap-client/src/main/java/itmo/web_services/WebClient.java#L209)
.

Изменены параметры использования wsimport:

```wsimport http://localhost:8080/BookService?wsdl -keep -b async.xml```

[*Файл
async.xml*](https://github.com/AnastasiyaSmirnova/web-services/blob/9b651b94ff2031c19d99a27f3cc14c5ea77c6010/soap-client/async.xml)

---
---

### Лабораторная работа 4

*Задание*

Необходимо выполнить задание из первой работы, но с использованием REST-сервиса. Таблицу базы данных, а также код для
работы с ней можно оставить без изменений.

[*Исходный код*](https://github.com/AnastasiyaSmirnova/web-services/releases/tag/laboratory-work-4)

* standalone REST application
    * [*server*](https://github.com/AnastasiyaSmirnova/web-services/tree/laboratory-work-4/rest-standalone-application)
    * [*
      client*](https://github.com/AnastasiyaSmirnova/web-services/blob/laboratory-work-4/rest-client/src/main/kotlin/itmo/web_services/impl/JavaEERestClient.kt)
* java EE REST application
    * [*server*](https://github.com/AnastasiyaSmirnova/web-services/tree/laboratory-work-4/java-ee-rest-application)
    * [*client*](https://github.com/AnastasiyaSmirnova/web-services/blob/laboratory-work-4/rest-client/src/main/kotlin/itmo/web_services/impl/JavaEERestClient.kt)

---
---

### Лабораторная работа 5

*Задание*

Необходимо выполнить задание из второй работы, но с использованием REST-сервиса. Таблицу базы данных, а также код для
работы с ней можно оставить без изменений.

[*Исходный код*](https://github.com/AnastasiyaSmirnova/web-services/tree/laboratory-work-5)

- [Измененные запросы в клиентской части](https://github.com/AnastasiyaSmirnova/web-services/blob/laboratory-work-5/rest-client/src/main/kotlin/itmo/web_services/impl/JavaEERestClient.kt)
- [Измененные запросы в серверной части](https://github.com/AnastasiyaSmirnova/web-services/blob/laboratory-work-5/java-ee-rest-application/src/main/java/itmo/webservices/service/BookService.java)

---
---

### Лабораторная работа 6

*Задание*

Необходимо выполнить задание из третьей работы, но с использованием REST-сервиса. Таблицу базы данных, а также код для
работы с ней можно оставить без изменений.

[*Исходный код*](https://github.com/AnastasiyaSmirnova/web-services/tree/laboratory-work-6)

- [Класс ошибки](https://github.com/AnastasiyaSmirnova/web-services/blob/laboratory-work-6/java-ee-rest-application/src/main/java/itmo/webservices/exception/InvalidBookParamException.java)
- [Пример обработки ошибки на клиенте](https://github.com/AnastasiyaSmirnova/web-services/blob/a96c1486777ae6d53d8bcd56358869023548d49f/rest-client/src/main/kotlin/itmo/web_services/impl/JavaEERestClient.kt#L109)

##### Дополнительное задание: аутентификация.

_*server*_
1. Добавлен endpoint login,
   logout: [AuthService](https://github.com/AnastasiyaSmirnova/web-services/blob/laboratory-work-6-auth/java-ee-rest-application/src/main/java/itmo/webservices/service/AuthService.java)
2. Добавлен
   фильтр [AuthenticationFilter](https://github.com/AnastasiyaSmirnova/web-services/blob/laboratory-work-6-auth/java-ee-rest-application/src/main/java/itmo/webservices/config/AuthenticationFilter.java)
   , который осуществляет проверку токена (крайне общая схема) и прерывает обработку запроса, если такой токен не найден [(*пример*)](https://github.com/AnastasiyaSmirnova/web-services/blob/d76cf6fcb9e0f9f2fd45d3c67ec5accbaca8df1c/java-ee-rest-application/src/main/java/itmo/webservices/config/AuthenticationFilter.java#L66)
3. Создана аннотация [Secured](https://github.com/AnastasiyaSmirnova/web-services/blob/laboratory-work-6-auth/java-ee-rest-application/src/main/java/itmo/webservices/annotation/Secured.java)
4. Методы, которые должны быть закрыты аутентификацией помечены аннотацией
   @Secured [BookService](https://github.com/AnastasiyaSmirnova/web-services/blob/d76cf6fcb9e0f9f2fd45d3c67ec5accbaca8df1c/java-ee-rest-application/src/main/java/itmo/webservices/service/BookService.java#L32)

_*client*_
1. Добавлены методы [login](https://github.com/AnastasiyaSmirnova/web-services/blob/04c174ba0be5b502a82dc3cfa1abe18e1dc69135/rest-client/src/main/kotlin/itmo/web_services/impl/JavaEERestClient.kt#L163), [logout](https://github.com/AnastasiyaSmirnova/web-services/blob/04c174ba0be5b502a82dc3cfa1abe18e1dc69135/rest-client/src/main/kotlin/itmo/web_services/impl/JavaEERestClient.kt#L183)
2. Добавлен заголовок [*Authorization = AUTHENTICATION_SCHEME: token*](https://github.com/AnastasiyaSmirnova/web-services/blob/04c174ba0be5b502a82dc3cfa1abe18e1dc69135/rest-client/src/main/kotlin/itmo/web_services/impl/JavaEERestClient.kt#L210)


---
---

###Лабораторная работа 7 

*Задание*

Требуется разработать приложение, осуществляющее регистрацию сервиса
в реестре jUDDI, а также поиск сервиса в реестре и обращение к нему.
Рекомендуется реализовать консольное приложение, которое обрабатывает две
команды. Итог работы первой команды – регистрация сервиса в реестре; вторая
команда должна осуществлять поиск сервиса, а также обращение к нему.

[*Исходный код:*](https://github.com/AnastasiyaSmirnova/web-services/tree/laboratory-work-7/JUDDIService)

- [*Registration*](https://github.com/AnastasiyaSmirnova/web-services/blob/laboratory-work-7/JUDDIService/src/main/java/RegistrationService.java)
- [*Search*](https://github.com/AnastasiyaSmirnova/web-services/blob/laboratory-work-7/JUDDIService/src/main/java/SearchService.java)