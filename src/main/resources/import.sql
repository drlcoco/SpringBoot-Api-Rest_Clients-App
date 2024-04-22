USE springboot_backend;
INSERT INTO clients (name, surname, email, create_at) VALUES
('John', 'Doe', 'john.doe@example.com', '2024-03-11 12:00:00'),
('Alice', 'Smith', 'alice.smith@example.com', '2024-03-11 12:15:00'),
('Bob', 'Johnson', 'bob.johnson@example.com', '2024-03-11 12:30:00'),
('Eva', 'Williams', 'eva.williams@example.com', '2024-03-11 12:45:00'),
('Charlie', 'Brown', 'charlie.brown@example.com', '2024-03-11 13:00:00'),
('Grace', 'Davis', 'grace.davis@example.com', '2024-03-11 13:15:00'),
('Michael', 'Miller', 'michael.miller@example.com', '2024-03-11 13:30:00'),
('Sophia', 'Moore', 'sophia.moore@example.com', '2024-03-11 13:45:00'),
('Daniel', 'Taylor', 'daniel.taylor@example.com', '2024-03-11 14:00:00'),
('Olivia', 'Clark', 'olivia.clark@example.com', '2024-03-11 14:15:00'),
('Liam', 'Martinez', 'liam.martinez@example.com', '2024-03-11 14:30:00'),
('Emma', 'Anderson', 'emma.anderson@example.com', '2024-03-11 14:45:00'),
('Noah', 'Hernandez', 'noah.hernandez@example.com', '2024-03-11 15:00:00'),
('Ava', 'Gonzalez', 'ava.gonzalez@example.com', '2024-03-11 15:15:00'),
('James', 'Wilson', 'james.wilson@example.com', '2024-03-11 15:30:00'),
('Isabella', 'Lopez', 'isabella.lopez@example.com', '2024-03-11 15:45:00'),
('William', 'Perez', 'william.perez@example.com', '2024-03-11 16:00:00'),
('Sophia', 'Turner', 'sophia.turner@example.com', '2024-03-11 16:15:00'),
('Oliver', 'Scott', 'oliver.scott@example.com', '2024-03-11 16:30:00'),
('Charlotte', 'Diaz', 'charlotte.diaz@example.com', '2024-03-11 16:45:00'),
('Benjamin', 'Nguyen', 'benjamin.nguyen@example.com', '2024-03-11 17:00:00'),
('Amelia', 'Gomez', 'amelia.gomez@example.com', '2024-03-11 17:15:00'),
('Elijah', 'Roberts', 'elijah.roberts@example.com', '2024-03-11 17:30:00'),
('Mia', 'Cook', 'mia.cook@example.com', '2024-03-11 17:45:00'),
('Lucas', 'Bailey', 'lucas.bailey@example.com', '2024-03-11 18:00:00'),
('Harper', 'Reyes', 'harper.reyes@example.com', '2024-03-11 18:15:00'),
('Mason', 'Russell', 'mason.russell@example.com', '2024-03-11 18:30:00'),
('Evelyn', 'Griffin', 'evelyn.griffin@example.com', '2024-03-11 18:45:00'),
('Ethan', 'Diaz', 'ethan.diaz@example.com', '2024-03-11 19:00:00'),
('Abigail', 'Stewart', 'abigail.stewart@example.com', '2024-03-11 19:15:00'),
('Alexander', 'Parker', 'alexander.parker@example.com', '2024-03-11 19:30:00'),
('Emily', 'Collins', 'emily.collins@example.com', '2024-03-11 19:45:00'),
('James', 'Edwards', 'james.edwards@example.com', '2024-03-11 20:00:00'),
('Avery', 'Mitchell', 'avery.mitchell@example.com', '2024-03-11 20:15:00'),
('Logan', 'Young', 'logan.young@example.com', '2024-03-11 20:30:00'),
('Sofia', 'King', 'sofia.king@example.com', '2024-03-11 20:45:00'),
('Benjamin', 'Hill', 'benjamin.hill@example.com', '2024-03-11 21:00:00'),
('Scarlett', 'Harrison', 'scarlett.harrison@example.com', '2024-03-11 21:15:00'),
('Jackson', 'Bennett', 'jackson.bennett@example.com', '2024-03-11 21:30:00');



USE springboot_backend;
UPDATE users 
SET email='john@john.john' 
WHERE username='John';
UPDATE users 
SET name='John' 
WHERE username='John';
UPDATE users 
SET surname='Doee' 
WHERE username='John';

USE springboot_backend;
UPDATE users 
SET password='$2a$10$47fTcJuaFFlOWxIWiT2a4uJsMFaRkONtvufgdMnsuO8yEOh64W97i' 
WHERE username='John';

USE springboot_backend;
UPDATE users 
SET password='$2a$10$xgAEFC3MkJmHhb4ucP1UVOq2WG5FzxErVydm.WKrlfgTjAjUN/8N2' 
WHERE username='Bob';

USE springboot_backend;
UPDATE users 
SET password='$2a$10$O4jmriF4rgrip/M9FXjlKevRE1lF8llMDMv9QO/uVaT2mhWyUoXfC' 
WHERE username='Alice';

USE springboot_backend;
INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 2);

USE springboot_backend;
INSERT INTO users (username, password, enabled) VALUES
('John', '', 1),
('Alice', '', 1),
('Bob', '', 1);

USE springboot_backend;
INSERT INTO roles (rolename) VALUES ('ROLE_USER');
INSERT INTO roles (rolename) VALUES ('ROLE_ADMIN');

USE springboot_backend;
INSERT INTO clients (name, surname, email, create_at, region_id) VALUES
('John', 'Doe', 'john.doe@example.com', '2024-03-11 12:00:00',1),
('Alice', 'Smith', 'alice.smith@example.com', '2024-03-11 12:15:00',2),
('Bob', 'Johnson', 'bob.johnson@example.com', '2024-03-11 12:30:00',3),
('Eva', 'Williams', 'eva.williams@example.com', '2024-03-11 12:45:00',4),
('Charlie', 'Brown', 'charlie.brown@example.com', '2024-03-11 13:00:00',5),
('Grace', 'Davis', 'grace.davis@example.com', '2024-03-11 13:15:00',6),
('Michael', 'Miller', 'michael.miller@example.com', '2024-03-11 13:30:00',7),
('Sophia', 'Moore', 'sophia.moore@example.com', '2024-03-11 13:45:00',8),
('Daniel', 'Taylor', 'daniel.taylor@example.com', '2024-03-11 14:00:00',9),
('Olivia', 'Clark', 'olivia.clark@example.com', '2024-03-11 14:15:00',10),
('Liam', 'Martinez', 'liam.martinez@example.com', '2024-03-11 14:30:00',1),
('Emma', 'Anderson', 'emma.anderson@example.com', '2024-03-11 14:45:00',2),
('Noah', 'Hernandez', 'noah.hernandez@example.com', '2024-03-11 15:00:00',3),
('Ava', 'Gonzalez', 'ava.gonzalez@example.com', '2024-03-11 15:15:00',4),
('James', 'Wilson', 'james.wilson@example.com', '2024-03-11 15:30:00',5),
('Isabella', 'Lopez', 'isabella.lopez@example.com', '2024-03-11 15:45:00',6),
('William', 'Perez', 'william.perez@example.com', '2024-03-11 16:00:00',7),
('Sophia', 'Turner', 'sophia.turner@example.com', '2024-03-11 16:15:00',8),
('Oliver', 'Scott', 'oliver.scott@example.com', '2024-03-11 16:30:00',9),
('Charlotte', 'Diaz', 'charlotte.diaz@example.com', '2024-03-11 16:45:00',10),
('Benjamin', 'Nguyen', 'benjamin.nguyen@example.com', '2024-03-11 17:00:00',1),
('Amelia', 'Gomez', 'amelia.gomez@example.com', '2024-03-11 17:15:00',2),
('Elijah', 'Roberts', 'elijah.roberts@example.com', '2024-03-11 17:30:00',3),
('Mia', 'Cook', 'mia.cook@example.com', '2024-03-11 17:45:00',4),
('Lucas', 'Bailey', 'lucas.bailey@example.com', '2024-03-11 18:00:00',5),
('Harper', 'Reyes', 'harper.reyes@example.com', '2024-03-11 18:15:00',6),
('Mason', 'Russell', 'mason.russell@example.com', '2024-03-11 18:30:00',7),
('Evelyn', 'Griffin', 'evelyn.griffin@example.com', '2024-03-11 18:45:00',8),
('Ethan', 'Diaz', 'ethan.diaz@example.com', '2024-03-11 19:00:00',9),
('Abigail', 'Stewart', 'abigail.stewart@example.com', '2024-03-11 19:15:00',10),
('Alexander', 'Parker', 'alexander.parker@example.com', '2024-03-11 19:30:00',1),
('Emily', 'Collins', 'emily.collins@example.com', '2024-03-11 19:45:00',2),
('James', 'Edwards', 'james.edwards@example.com', '2024-03-11 20:00:00',3),
('Avery', 'Mitchell', 'avery.mitchell@example.com', '2024-03-11 20:15:00',4),
('Logan', 'Young', 'logan.young@example.com', '2024-03-11 20:30:00',5),
('Sofia', 'King', 'sofia.king@example.com', '2024-03-11 20:45:00',6),
('Benjamin', 'Hill', 'benjamin.hill@example.com', '2024-03-11 21:00:00',7),
('Scarlett', 'Harrison', 'scarlett.harrison@example.com', '2024-03-11 21:15:00',8),
('Jackson', 'Bennett', 'jackson.bennett@example.com', '2024-03-11 21:30:00',9);

USE springboot_backend;
INSERT INTO regions (id, name) VALUES (1, 'North America');
INSERT INTO regions (id, name) VALUES (2, 'Europe');
INSERT INTO regions (id, name) VALUES (3, 'Asia');
INSERT INTO regions (id, name) VALUES (4, 'South America');
INSERT INTO regions (id, name) VALUES (5, 'Africa');
INSERT INTO regions (id, name) VALUES (6, 'Oceania');
INSERT INTO regions (id, name) VALUES (7, 'Antarctica');
INSERT INTO regions (id, name) VALUES (8, 'Middle East');
INSERT INTO regions (id, name) VALUES (9, 'Central America');
INSERT INTO regions (id, name) VALUES (10, 'Caribbean');


USE springboot_backend;
INSERT INTO invoices (description, observation, client_id, create_at) VALUES ('Factura 1, página web', null, 40, NOW());
INSERT INTO invoice_items (quantity, invoice_id, product_id) VALUES (1, 1, 1);
INSERT INTO invoice_items (quantity, invoice_id, product_id) VALUES (2, 1, 4);
INSERT INTO invoice_items (quantity, invoice_id, product_id) VALUES (1, 1, 5);
INSERT INTO invoice_items (quantity, invoice_id, product_id) VALUES (1, 1, 7);
INSERT INTO invoices (description, observation, client_id, create_at) VALUES ('Factura 2, backend', null, 40, NOW());
INSERT INTO invoice_items (quantity, invoice_id, product_id) VALUES (1, 2, 8);
INSERT INTO invoice_items (quantity, invoice_id, product_id) VALUES (2, 2, 14);
INSERT INTO invoice_items (quantity, invoice_id, product_id) VALUES (1, 2, 15);
INSERT INTO invoice_items (quantity, invoice_id, product_id) VALUES (1, 2, 17);
INSERT INTO invoices (name, price, create_at) VALUES ('Product 3', 15.49, NOW());
INSERT INTO invoices (name, price, create_at) VALUES ('Product 4', 25.99, NOW());
INSERT INTO invoices (name, price, create_at) VALUES ('Product 5', 8.99, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 6', 12.79, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 7', 29.99, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 8', 17.99, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 9', 11.29, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 10', 14.99, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 11', 9.99, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 12', 22.49, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 13', 18.59, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 14', 16.79, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 15', 13.99, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 16', 20.49, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 17', 24.99, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 18', 27.49, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 19', 21.99, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 20', 31.99, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 21', 28.99, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 22', 23.79, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 23', 26.49, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 24', 30.99, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 25', 33.49, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 26', 36.99, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 27', 39.99, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 28', 41.49, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 29', 44.99, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 30', 49.99, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 31', 53.49, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 32', 56.99, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 33', 59.49, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 34', 62.99, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 35', 64.99, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 36', 69.99, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 37', 73.49, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 38', 76.99, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 39', 79.49, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 40', 84.99, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 41', 89.99, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 42', 92.49, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 43', 94.99, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 44', 99.49, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 45', 104.99, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 46', 109.99, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 47', 113.49, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 48', 116.99, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 49', 119.49, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Product 50', 124.99, NOW());

USE springboot_backend;
UPDATE invoices set observation = "Esta factura está pendiente de revisión" where id = 1;
UPDATE invoices set observation = "Esta factura ya está revisada por contabilidad" where id = 2;
