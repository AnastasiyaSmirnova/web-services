create table books
(
    id               serial PRIMARY KEY,
    title            varchar(30),
    author           varchar(50),
    publishing_house varchar(20),
    language         varchar(10),
    pages            integer
);

