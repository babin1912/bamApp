drop table if exists persons;
create table if not exists persons (
    id int not null AUTO_INCREMENT,
    firstname varchar(255) not null,
    lastname varchar(255) not null,
    gender varchar(1) not null,
    accountBallance int not null,
    primary key(id)
);

drop table if exists cards;
create table if not exists cards (
    cardNumber varchar(16),
    userId int unique,
    primary key (cardNumber),
    FOREIGN KEY (userId) REFERENCES PERSONS(id)
);

