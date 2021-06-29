
drop table if exists cards;
$$
drop table if exists people;
$$
create table if not exists people (
    person_id bigint not null AUTO_INCREMENT,
    firstname varchar(255) not null,
    lastname varchar(255) not null,
    gender varchar(1) not null,
    account_ballance int not null,
    primary key(person_id)
    );
$$

create table if not exists cards (
    card_number varchar(16),
    person_id bigint,
    primary key (card_number),
    constraint fk_person_id foreign key (person_id) references people(person_id)
    );
$$
drop procedure if exists get_card_by_id;
$$
CREATE PROCEDURE `get_card_by_id`(IN id varchar(255))
BEGIN
SELECT * FROM cards WHERE card_number = id
    LIMIT 1;
END
$$

drop procedure if exists `card_by_id`;
$$

CREATE PROCEDURE `card_by_id`(IN id varchar(16), out cardNumber varchar(16), out personId bigint)
BEGIN
SELECT card_number, person_id into cardNumber, personId
FROM cards
WHERE card_number = id
    LIMIT 1;
END
$$

drop procedure if exists find_all_cards;
$$
CREATE PROCEDURE `find_all_cards`()
BEGIN
SELECT * FROM cards;
END
$$

drop procedure if exists find_all_people;
$$
CREATE PROCEDURE `find_all_people`()
BEGIN
SELECT * FROM people;
END
$$

drop procedure if exists get_person_by_id;
$$
CREATE PROCEDURE `get_person_by_id`(IN id bigint)
BEGIN
SELECT * FROM people WHERE person_id = id
    LIMIT 1;
END
$$
drop procedure if exists get_card_by_user_id;
$$
CREATE PROCEDURE `get_card_by_user_id`(IN personId bigint)
BEGIN
SELECT * FROM cards WHERE person_id = personId
    LIMIT 1;
END
$$

