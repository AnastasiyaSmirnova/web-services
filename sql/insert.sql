alter sequence books_id_seq restart with 1;

insert into books(title, author,  publishing_house, language, pages)
values ('PeaceAndWar', 'LevNikolayevichTolstoy', 'RussianMessenger', 'RUSSIAN', 1300);

insert into books(title, author,  publishing_house, language, pages)
values ('CrimeAndPunishment', 'FedorMikhailovichDostoevsky',  'Science', 'RUSSIAN', 608);

insert into books(title, author,  publishing_house, language, pages)
values ('EugeneOnegin', 'AlexanderSergeevichPushkin', 'ABC', 'RUSSIAN', 400);

insert into books(title, author,  publishing_house, language, pages)
values ('AndThenThereWereNone', 'AgataKristi','Harper', 'ENGLISH',258);