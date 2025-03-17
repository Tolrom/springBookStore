-- Création de la table
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user`(
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE book (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    description VARCHAR(255) NOT NULL,
    publication_date DATE NOT NULL,
    genre VARCHAR(50),
    author VARCHAR(50),
    editor VARCHAR(50)
);

-- Ajout d'enregistements
INSERT INTO book (title, description, publication_date) VALUES
    ('Das Kapital', 'Kritik der politischen Ökonomie', '1867-06-19'),
    ('Book', 'A book', '2024-11-21'),
    ('No Book', 'Not a book', '2025-02-14');

INSERT INTO `user` (firstname, lastname, email, password) VALUES
    ('Mathieu', 'Mithridate', 'mathieumith@test.com', '1234'),
    ('Jean', 'Albert', 'jeanalbert@test.fr', '1234'),
    ('Marie', 'Durand', 'mariedurand@mail.com', '1234');

CREATE USER IF NOT EXISTS test PASSWORD '1234' ADMIN;