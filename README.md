# web-services

Лабораторные работы по дисциплине "Технологии Веб сервисов"

---
---

### Лабораторная работа 1

*Задание*

В данной работе требуется создать таблицу в базе данных, содержащую не
менее пяти полей, а также реализовать возможность поиска по любым
комбинациям полей с помощью SOAP-сервиса. Данные для поиска должны
передаваться в метод сервиса в качестве аргументов.

Веб-сервис необходимо реализовать в виде standalone-приложения и J2EE-
приложения. При реализации в виде J2EE-приложения следует на стороне сервера
приложений настроить источник данных и осуществлять его инъекцию в коде
сервиса.

Для демонстрации работы разработанных сервисов следует также
разработать и клиентское консольное приложение.

[*Исходный код*](https://github.com/AnastasiyaSmirnova/web-services/tree/laboratory-work-1)

[*Скрипты для работы с Базой данных*](https://github.com/AnastasiyaSmirnova/web-services/tree/laboratory-work-1/sql)

*Структура проекта*

 1. Standalone-application
    * model 
      * Book
    * dao 
      * Executor 
      * BookDao
    * service
      * BookService
    * StandaloneApplication ( main() ) 
    * ConnectionUtil (connection tp DB)
 

 2. Java EE application ( Glassfish ) 
     * model
         * Book
     * dao
         * Executor
         * BookDao
     * service
         * BookService <= DataSource ("jdbc/ifmo-ws") 
         
