CREATE TABLE fines (
    fine_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    borrowing_id BIGINT NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    paid_amount DECIMAL(10,2) DEFAULT 0,
    status VARCHAR(20) DEFAULT 'UNPAID',
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    in_active BOOLEAN DEFAULT FALSE,
    is_delete BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (borrowing_id) REFERENCES borrowings(borrowing_id)
);