-- ODDZIAŁY
INSERT INTO DEPARTMENTS (NAME) VALUES
('BEGIN'), ('HUMAN_RESOURCES'), ('MANUFACTURE'), ('FINANCE'), ('SERVIS'), ('STOREHOUSE'), ('CUSTOMER_SERVICE'), ('END');


-- UPRAWNIENIA
INSERT INTO ROLES(ID, NAME) VALUES
(1, "HR"), (2, "MANUFACTURE"), (3, "FINANCE"), (4, "SERVIS"), (5, "STOREHOUSE"), (6, "CUSTOMER_SERVICE"), (7, "ROOT");

COMMIT;

-- UŻYTKOWNICY
-- hasło jest takie same jak login
INSERT INTO USERS(ID, NAME, SURNAME, LOGIN, PASSWORD, ID_DEPARTMENT) VALUES
(1, 'Jan', 'Kowalski', 'kadry', 
UPPER('d29a78bffdc6f3b5ec8a042e40cf51daef546074944365dac2c5d3fb0f3e82351be8a19acf5278bf496c66e676677a53de5c1efa78fbd0530235fca629ad0073'), 
(SELECT ID FROM DEPARTMENTS WHERE NAME = 'HUMAN_RESOURCES')),
(2, 'Marian', 'Malinowski', 'produkcja', 
UPPER('9875112cc0e4164ec4fce37286d99c50af2c6f83f81f9c0c5ce6863c0e7630df72fae2b08e1d75571f7b0abb278a25a8c8e26b02564abecaf94a395035117566'),
(SELECT ID FROM DEPARTMENTS WHERE NAME = 'MANUFACTURE')),
(3, 'Magda', 'Pigułowska', 'finanse', 
UPPER('84af1982c3effbefad2db842c92200c57999a840f9acb3f5bbce1701ce042433f1e604368340eb0b0e07729ff6e3b9bdae5f10e880869c90701e169cf0e32218'),
(SELECT ID FROM DEPARTMENTS WHERE NAME = 'FINANCE')),
(4, 'Adrianna', 'Zielińska', 'serwis', 
UPPER('127580a0e32a932b7a815047e0a2cec8d893190c6e87a575ce9af0d2a8db39ec74bafb41c3f5fda35cb077794baba200c62eff51dc7988dfef661214e77c72fb'),
(SELECT ID FROM DEPARTMENTS WHERE NAME = 'CUSTOMER_SERVICE')),
(5, 'Mariusz', 'Wyszyński', 'magazyn', 
UPPER('ca97c14fde091c45be5a21fe4abe7c235dcd84bfa662e6a20f5f681a2b307bd5d6f7b9da798dcfb01d07989d517a7a6487d93e7e80dc28a1739282cda10006c4'), 
(SELECT ID FROM DEPARTMENTS WHERE NAME = 'STOREHOUSE')),
(6, 'Sabina', 'Jutrzenka', 'obsluga', 
UPPER('2fce4c555ecadcb54952e04ee09e65549e77d5d796f485d6a413dde2e4164821145dcc8ae43d2001c567ba612160105e2bedbeb51a96c5b8bd764b5560273268'),
(SELECT ID FROM DEPARTMENTS WHERE NAME = 'CUSTOMER_SERVICE')),
(7, 'Maćko', 'z Bogdańca', 'root', 
UPPER('6f9d2dbd5f05435803378c244aebe0193843105fff77602b8000faa7fb929f0146119a53f3bb8755f9f099e57edd45e3949a985d71368994687814b72702aae3'),
(SELECT ID FROM DEPARTMENTS WHERE NAME = 'HUMAN_RESOURCES'));

COMMIT;

-- UPRAWNIENIA UŻYTKOWNIKÓW
INSERT INTO USER_ROLES(USER_ID, ROLE_ID) VALUES
(1, 1), (2, 2), (3, 3), (4, 4), (5, 5), (6, 6), (7, 7), (7, 1), (7, 2), (7, 3), (7, 4), (7, 5), (7, 6);
COMMIT;


-- TYPY DOKUMNETÓW
INSERT INTO DOCUMENT_TYPES (TYPE_NAME) VALUE ('TEST');

INSERT INTO DOCUMENT_TYPES (TYPE_NAME) VALUE ('BUSINESS_TRAVEL_CLEARING');
INSERT INTO DOCUMENT_TYPES (TYPE_NAME) VALUE ('CANDIDATE_REQUEST');
INSERT INTO DOCUMENT_TYPES (TYPE_NAME) VALUE ('HOLIDAYS_REQUEST');
INSERT INTO DOCUMENT_TYPES (TYPE_NAME) VALUE ('INVOICE_CLEARING');
INSERT INTO DOCUMENT_TYPES (TYPE_NAME) VALUE ('NEW_CANDIDATE');
INSERT INTO DOCUMENT_TYPES (TYPE_NAME) VALUE ('RESIGNATION_EMPLOYEE');
INSERT INTO DOCUMENT_TYPES (TYPE_NAME) VALUE ('RESIGNATION_EMPLOYER');
INSERT INTO DOCUMENT_TYPES (TYPE_NAME) VALUE ('SICK_LEAVE');
INSERT INTO DOCUMENT_TYPES (TYPE_NAME) VALUE ('TRAINING_CLEARING');

-- reszta typów jest do dopisania


COMMIT;