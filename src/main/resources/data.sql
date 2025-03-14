-- Création de la table
DROP TABLE IF EXISTS book;

CREATE TABLE book (
    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    title VARCHAR(50) NOT NULL,
    description VARCHAR(255) NOT NULL,
    publication_date DATE NOT NULL
);

-- Ajout d'enregistements
INSERT INTO book (title, description, publication_date) VALUES
    ('Das Kapital', 'Kritik der politischen Ökonomie', '1867-06-19'),
    ('Book', 'A book', '2024-11-21'),
    ('No Book', 'Not a book', '2025-02-14');

CREATE USER IF NOT EXISTS test PASSWORD '1234' ADMIN;