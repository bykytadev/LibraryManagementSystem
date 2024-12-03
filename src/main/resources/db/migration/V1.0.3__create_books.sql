CREATE TABLE books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255),
    quantity INT NOT NULL DEFAULT 0,

    created_date DATETIME NOT NULL,
    modified_date DATETIME
);