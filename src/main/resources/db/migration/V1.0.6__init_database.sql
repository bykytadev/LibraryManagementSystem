INSERT INTO users (user_id, username, full_name, email, phone, status) VALUES
(UUID(), 'john_doe', 'John Doe', 'john.doe@example.com', '1234567890', 'ACTIVE'),
(UUID(), 'jane_smith', 'Jane Smith', 'jane.smith@example.com', '0987654321', 'ACTIVE'),
(UUID(), 'alice_jones', 'Alice Jones', 'alice.jones@example.com', '1122334455', 'ACTIVE'),
(UUID(), 'bob_brown', 'Bob Brown', 'bob.brown@example.com', '2233445566', 'ACTIVE'),
(UUID(), 'charlie_davis', 'Charlie Davis', 'charlie.davis@example.com', '3344556677', 'ACTIVE');

INSERT INTO books (title, author, general, quantity, available_quantity) VALUES
('The Great Gatsby', 'F. Scott Fitzgerald', 'Fiction', 10, 10),
('To Kill a Mockingbird', 'Harper Lee', 'Fiction', 8, 8),
('1984', 'George Orwell', 'Dystopian', 15, 15),
('Pride and Prejudice', 'Jane Austen', 'Romance', 5, 5),
('The Catcher in the Rye', 'J.D. Salinger', 'Fiction', 12, 12);

INSERT INTO borrowings (user_id, book_id, borrow_date, due_date, status) VALUES
((SELECT user_id FROM users WHERE username = 'john_doe'), (SELECT book_id FROM books WHERE title = 'The Great Gatsby'), CURRENT_TIMESTAMP, DATE_ADD(CURRENT_TIMESTAMP, INTERVAL 14 DAY), 'BORROWED'),
((SELECT user_id FROM users WHERE username = 'jane_smith'), (SELECT book_id FROM books WHERE title = 'To Kill a Mockingbird'), CURRENT_TIMESTAMP, DATE_ADD(CURRENT_TIMESTAMP, INTERVAL 14 DAY), 'BORROWED'),
((SELECT user_id FROM users WHERE username = 'alice_jones'), (SELECT book_id FROM books WHERE title = '1984'), CURRENT_TIMESTAMP, DATE_ADD(CURRENT_TIMESTAMP, INTERVAL 14 DAY), 'BORROWED'),
((SELECT user_id FROM users WHERE username = 'bob_brown'), (SELECT book_id FROM books WHERE title = 'Pride and Prejudice'), CURRENT_TIMESTAMP, DATE_ADD(CURRENT_TIMESTAMP, INTERVAL 14 DAY), 'BORROWED'),
((SELECT user_id FROM users WHERE username = 'charlie_davis'), (SELECT book_id FROM books WHERE title = 'The Catcher in the Rye'), CURRENT_TIMESTAMP, DATE_ADD(CURRENT_TIMESTAMP, INTERVAL 14 DAY), 'BORROWED');

INSERT INTO fines (borrowing_id, amount, paid_amount, status) VALUES
((SELECT borrowing_id FROM borrowings WHERE user_id = (SELECT user_id FROM users WHERE username = 'john_doe') AND book_id = (SELECT book_id FROM books WHERE title = 'The Great Gatsby')), 5.00, 0, 'UNPAID'),
((SELECT borrowing_id FROM borrowings WHERE user_id = (SELECT user_id FROM users WHERE username = 'jane_smith') AND book_id = (SELECT book_id FROM books WHERE title = 'To Kill a Mockingbird')), 3.00, 0, 'UNPAID'),
((SELECT borrowing_id FROM borrowings WHERE user_id = (SELECT user_id FROM users WHERE username = 'alice_jones') AND book_id = (SELECT book_id FROM books WHERE title = '1984')), 4.00, 0, 'UNPAID'),
((SELECT borrowing_id FROM borrowings WHERE user_id = (SELECT user_id FROM users WHERE username = 'bob_brown') AND book_id = (SELECT book_id FROM books WHERE title = 'Pride and Prejudice')), 2.00, 0, 'UNPAID'),
((SELECT borrowing_id FROM borrowings WHERE user_id = (SELECT user_id FROM users WHERE username = 'charlie_davis') AND book_id = (SELECT book_id FROM books WHERE title = 'The Catcher in the Rye')), 6.00, 0, 'UNPAID');