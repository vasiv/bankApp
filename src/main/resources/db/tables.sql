DROP TABLE IF EXISTS address CASCADE;
CREATE TABLE address (
	address_id SERIAL PRIMARY KEY,
	country VARCHAR(255) NOT NULL
	city VARCHAR(255) NOT NULL,
	street VARCHAR(255) NOT NULL,
	house_number VARCHAR(255) NOT NULL,
	place_number VARCHAR(255),
	postcode VARCHAR(255) NOT NULL,
);

DROP TABLE IF EXISTS person CASCADE;
CREATE TABLE person (
	person_id SERIAL PRIMARY KEY,
	login VARCHAR(255) UNIQUE NOT NULL,
	firstName VARCHAR(255) NOT NULL,
	secondName VARCHAR(255) NOT NULL,
	lastName VARCHAR(255) NOT NULL,
	personalIdentityNumber VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
    isActive BOOLEAN
);

DROP TABLE IF EXISTS account CASCADE;
CREATE TABLE account (
    account_id SERIAL PRIMARY KEY,
    number VARCHAR(255) NOT NULL,
    funds MONEY  (255) NOT NULL,
    accountType INTEGER REFERENCES accountType(accountType_id)
);

DROP TABLE IF EXISTS accountType CASCADE;
CREATE TABLE storey (
	storey_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(500),
);

DROP TABLE IF EXISTS account_type CASCADE;
CREATE TABLE room_type(
	room_type_id SERIAL PRIMARY KEY,
	name VARCHAR(2048) NOT NULL
);


DROP TABLE IF EXISTS settings CASCADE;
CREATE TABLE settings
(
	key character varying(512) NOT NULL PRIMARY KEY,
	value character varying(512) NOT NULL
);


