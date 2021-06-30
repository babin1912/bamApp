insert  into people(person_id ,firstname, lastname, gender, account_ballance)
values ("0",'peter', 'petrovic', 'M', 0)
    ON DUPLICATE KEY UPDATE firstname = 'peter', lastname = 'petrovic', gender = 'M', account_ballance = 0
$$
insert  into people(person_id ,firstname, lastname, gender, account_ballance)
values ("1",'peter', 'petrovic', 'M', 0)
ON DUPLICATE KEY UPDATE firstname = 'frantisek', lastname = 'modry', gender = 'M', account_ballance = 0
$$
insert into cards(card_number, person_id) values ('00', 1)
ON DUPLICATE KEY UPDATE card_number = '00', person_id = 1
$$
insert into cards(card_number, person_id) values ('01', 1)
ON DUPLICATE KEY UPDATE card_number = '00', person_id = 1
$$

