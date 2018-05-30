--test users on OKTA password: 1qaz2wsx#EDC

INSERT INTO address (address_id,country,city,street,house_number,postcode) VALUES (1,'Poland','Kielce','Duża','7','25-304');

INSERT INTO person (email,first_name,second_name,last_name,address,personal_identity_number,is_active) VALUES ('0vasiv0@gmail.com','Szymon','','Ciepluch',1,'12345678912',true);
INSERT INTO person (email,first_name,second_name,last_name,address,personal_identity_number,is_active) VALUES ('a.binkowski@okta.com','Albert','','Bińkowski',1,'12345678312',true);

INSERT INTO account_type (account_type_id,name,description) VALUES (1,'Konto dla mlodych','Konto dla klientow do 26 roku zycia');

INSERT INTO account (account_id,number,funds,account_type,owner) VALUES (1,'0011112222333344445555',450.45,1,'a.binkowski@okta.com');
INSERT INTO account (account_id,number,funds,account_type,owner) VALUES (2,'1122223333444455556666',100,1,'a.binkowski@okta.com');

INSERT INTO transfer (transfer_id, sender, receiver, date, tran)
CREATE TABLE transfer (
    transfer_id SERIAL PRIMARY KEY,
    sender INTEGER NOT NULL REFERENCES account(account_id),
    receiver INTEGER NOT NULL REFERENCES account(account_id),
    date DATE NOT NULL,
    transfer_amount DECIMAL(10,2) NOT NULL,
    is_periodic BOOLEAN NOT NULL
);