DROP TABLE IF EXISTS address CASCADE;
CREATE TABLE address (
    address_id SERIAL PRIMARY KEY,
    country VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    street VARCHAR(255) NOT NULL,
    house_number VARCHAR(255) NOT NULL,
    place_number VARCHAR(255),
    postcode VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS person CASCADE;
CREATE TABLE person (
    person_id SERIAL PRIMARY KEY,
    login VARCHAR(255) UNIQUE NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    second_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    address INTEGER REFERENCES address(address_id),
    personal_identity_number VARCHAR(255) UNIQUE NOT NULL,
    email VARCHAR(255) NOT NULL,
    is_active BOOLEAN
);

DROP TABLE IF EXISTS account_type CASCADE;
CREATE TABLE account_type (
    account_type_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(500)
);

DROP TABLE IF EXISTS account CASCADE;
CREATE TABLE account (
    account_id SERIAL PRIMARY KEY,
    number VARCHAR(255) NOT NULL,
    funds MONEY  NOT NULL,
    account_type INTEGER REFERENCES account_type(account_type_id),
    owner INTEGER REFERENCES person(person_id)
);

DROP TABLE IF EXISTS defined_receiver CASCADE;
CREATE TABLE defined_receiver (
    defined_receiver_id SERIAL PRIMARY KEY,
    sender INTEGER REFERENCES account(account_id),
    receiver INTEGER REFERENCES account(account_id)
);

--DROP TABLE IF EXISTS periodicTransfer CASCADE;
--CREATE TABLE periodicTransfer (
--    periodicTransfer_id SERIAL PRIMARY KEY,
--    name VARCHAR(255) NOT NULL,
--    number VARCHAR(255) NOT NULL,
--    transferAmount MONEY (255) NOT NULL,
--    dayOfMonth VARCHAR(255) NOT NULL,
--    isAuthorization BOOLEAN,
--);

--DROP TABLE IF EXISTS debitCard CASCADE;
--CREATE TABLE debitCard (
--    debitCard_id SERIAL PRIMARY KEY,
--    cardNumber VARCHAR(255) NOT NULL,
--    securityCode VARCHAR(255) NOT NULL,
--    account INTEGER REFERENCES account(account_id)
--);

DROP TABLE IF EXISTS transfer CASCADE;
CREATE TABLE transfer (
    transfer_id SERIAL PRIMARY KEY,
    senderAccountNumber VARCHAR(255) NOT NULL,
    receiverAccountNumber VARCHAR(255) NOT NULL,
    nameReceiver VARCHAR(255) NOT NULL,
    date VARCHAR(255) NOT NULL,
    transferAmount VARCHAR(255) NOT NULL,
    isAuthorization BOOLEAN,
    isPeriodic BOOLEAN,

    // czy tutaj klucz obcy z przelewu okresowego oraz zdefiniowanych odbiorców?
);

--DROP TABLE IF EXISTS loan CASCADE;
--CREATE TABLE loan (
--    loan_id SERIAL PRIMARY KEY,
--    loanAmount MONEY (255) NOT NULL,
--    totalInstallments VARCHAR(255) NOT NULL,
--    remainingInstallments VARCHAR(255) NOT NULL,
--    peroid VARCHAR(255) NOT NULL,
--    account INTEGER REFERENCES account(account_id),
--);

--DROP TABLE IF EXISTS settings CASCADE;
--CREATE TABLE settings (
--    settings_id SERIAL PRIMARY KEY,
--    password VARCHAR(255) NOT NULL,
--    isAuthorization BOOLEAN,
--    account INTEGER REFERENCES account(account_id),
--
--    // czy tutaj np. dać klucz z adresu żeby móc zmienić te dane?
--    // bo chyba bez sensu kolejny raz robić tu te pola.
--);

--https://dev-602945.oktapreview.com/
