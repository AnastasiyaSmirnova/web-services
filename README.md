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
##### Дополнительное задание: Обработка бинарных данных.

Реализованы 2 метода передачи изображений:

* send image as String 
* send image as attachment

[Обновленный BookService](https://github.com/AnastasiyaSmirnova/web-services/blob/laboratory-work-3-improvements/standalone-application/src/main/java/itmo/web_services/service/BooksWebService.java)

[Вспомогательный класс ImageUtils](https://github.com/AnastasiyaSmirnova/web-services/blob/laboratory-work-3-improvements/standalone-application/src/main/java/itmo/web_services/ImageUtils.java)

В результате выполнения запросов клиентом были получены следующие изображения: 

[Певрое прочитанное клиентом изображение](https://github.com/AnastasiyaSmirnova/web-services/blob/laboratory-work-3-improvements/soap-client/image_as_string.jpg)

[Второе прочитанное клиентом изображение](https://github.com/AnastasiyaSmirnova/web-services/blob/laboratory-work-3-improvements/soap-client/image_as_attachment.jpg)


---
---

### Лабораторная работа 4

*Задание*

Необходимо выполнить задание из первой работы, но с использованием
REST-сервиса. Таблицу базы данных, а также код для работы с ней можно оставить
без изменений.

[*Исходный код*](https://github.com/AnastasiyaSmirnova/web-services/releases/tag/laboratory-work-4)

* standalone REST application
    * [*server*](https://github.com/AnastasiyaSmirnova/web-services/tree/laboratory-work-4/rest-standalone-application)
    * [*client*](https://github.com/AnastasiyaSmirnova/web-services/blob/laboratory-work-4/rest-client/src/main/kotlin/itmo/web_services/impl/JavaEERestClient.kt)
* java EE REST application
  * [*server*](https://github.com/AnastasiyaSmirnova/web-services/tree/laboratory-work-4/java-ee-rest-application)
  * [*client*](https://github.com/AnastasiyaSmirnova/web-services/blob/laboratory-work-4/rest-client/src/main/kotlin/itmo/web_services/impl/JavaEERestClient.kt)