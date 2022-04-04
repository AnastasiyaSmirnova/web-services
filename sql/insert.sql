alter sequence books_id_seq restart with 1;

insert into books(title, author,  publishing_house, language, pages)
values ('Peace and war', 'Lev Nikolayevich Tolstoy', 'Russian messenger', 'russian', 1300);

insert into books(title, author,  publishing_house, language, pages)
values ('Crime and Punishment', 'Fedor Mikhailovich Dostoevsky',  'Science', 'russian', 608);

insert into books(title, author,  publishing_house, language, pages)
values ('Eugene Onegin', 'Alexander Sergeevich Pushkin', 'ABC', 'russian', 400);

insert into books(title, author,  publishing_house, language, pages)
values ('And then there were none', 'Agata Kristi','Harper', 'english',258);