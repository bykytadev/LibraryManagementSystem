INSERT INTO users (id, name, email, role, created_date, modified_date) VALUES
    ('550e8400-e29b-41d4-a716-446655440000', 'Nguyễn Văn A', 'nva@example.com', 'USER', NOW(), NOW()),
    ('550e8400-e29b-41d4-a716-446655440001', 'Trần Thị B', 'ttb@example.com', 'USER', NOW(), NOW()),
    ('550e8400-e29b-41d4-a716-446655440002', 'Lê Văn C', 'lvc@example.com', 'ADMIN', NOW(), NOW()),
    ('550e8400-e29b-41d4-a716-446655440003', 'Phạm Thị D', 'ptd@example.com', 'USER', NOW(), NOW()),
    ('550e8400-e29b-41d4-a716-446655440004', 'Hoàng Văn E', 'hve@example.com', 'USER', NOW(), NOW());


INSERT INTO categories (name, created_date, modified_date) VALUES
    ('Tiểu thuyết', NOW(), NOW()),
    ('Khoa học', NOW(), NOW()),
    ('Lịch sử', NOW(), NOW()),
    ('Kỹ năng sống', NOW(), NOW()),
    ('Thiếu nhi', NOW(), NOW());

INSERT INTO books (title, author, quantity, created_date, modified_date) VALUES
    ('Cuốn theo chiều gió', 'Margaret Mitchell', 10, NOW(), NOW()),
    ('Hành trình về phương Đông', 'Baird T. Spalding', 8, NOW(), NOW()),
    ('Đắc Nhân Tâm', 'Dale Carnegie', 15, NOW(), NOW()),
    ('Harry Potter và Hòn đá Phù thủy', 'J.K. Rowling', 20, NOW(), NOW()),
    ('Sapiens: Lược sử loài người', 'Yuval Noah Harari', 5, NOW(), NOW());


INSERT INTO book_categories (book_id, category_id) VALUES
    (1, 1),
    (2, 2),
    (3, 4),
    (4, 5),
    (5, 2),
    (1, 3),
    (2, 3),
    (3, 1),
    (4, 4),
    (5, 5);

INSERT INTO borrow_records (user_id, book_id, borrow_date, return_date) VALUES
    ('550e8400-e29b-41d4-a716-446655440000', 1, '2023-09-01', '2023-09-10'),
    ('550e8400-e29b-41d4-a716-446655440001', 2, '2023-09-05', NULL),
    ('550e8400-e29b-41d4-a716-446655440002', 3, '2023-09-10', '2023-09-20'),
    ('550e8400-e29b-41d4-a716-446655440003', 4, '2023-09-15', NULL),
    ('550e8400-e29b-41d4-a716-446655440004', 5, '2023-09-20', '2023-09-25');
