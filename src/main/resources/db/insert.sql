--test users on OKTA password: 1qaz2wsx#EDC

INSERT INTO address (address_id,country,city,street,house_number,postcode) VALUES (1,'Poland','Kielce','Duża','7','25-304');

INSERT INTO person (email,first_name,second_name,last_name,address,personal_identity_number,is_active, is_consultant) VALUES ('0vasiv0@gmail.com','Szymon','','Ciepluch',1,'12345678912',true, true);
INSERT INTO person (email,first_name,second_name,last_name,address,personal_identity_number,is_active, is_consultant) VALUES ('a.binkowski@okta.com','Albert','','Bińkowski',1,'12345678312',true, false);

INSERT INTO account_type (account_type_id,name,description) VALUES (1,'Konto dla mlodych','Konto dla klientow do 26 roku zycia');

INSERT INTO account (account_id,number,funds,account_type,owner,is_active) VALUES (1,'0011112222333344445555',450.45,1,'a.binkowski@okta.com',true);
INSERT INTO account (account_id,number,funds,account_type,owner,is_active) VALUES (2,'1122223333444455556666',100,1,'a.binkowski@okta.com',true);

INSERT INTO transfer (transfer_id, sender, receiver, date, transfer_amount, description, is_periodic) VALUES (1, 1, 2, '2018-05-12', 50.00, 'Rachunki', false);

INSERT INTO role (role_id,role) VALUES (1,'Customer');
INSERT INTO role (role_id,role) VALUES (2,'Consultant');

INSERT INTO people_with_roles (people_with_roles_id,role_id,person_id) VALUES (1,1,'a.binkowski@okta.com');
INSERT INTO people_with_roles (people_with_roles_id,role_id,person_id) VALUES (2,2,'0vasiv0@gmail.com');
