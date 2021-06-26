drop table if exists cards;

drop table if exists people;

create table if not exists people (
    person_id bigint not null AUTO_INCREMENT,
    firstname varchar(255) not null,
    lastname varchar(255) not null,
    gender varchar(1) not null,
    account_ballance int not null,
    primary key(person_id)
);


create table if not exists cards (
    card_number varchar(16),
    person_id bigint,
    primary key (card_number),
    constraint fk_person_id foreign key (person_id) references people(person_id)
);

