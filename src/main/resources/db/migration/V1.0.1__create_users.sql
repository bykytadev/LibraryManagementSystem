CREATE TABLE users (
    id CHAR(36) PRIMARY KEY DEFAULT (UUID()),
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    role ENUM('admin', 'user') DEFAULT 'user',

    created_date DATETIME NOT NULL,
    modified_date DATETIME
);