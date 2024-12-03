CREATE TABLE categories (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL,

    created_date DATETIME NOT NULL,
    modified_date DATETIME
);