-- Trigger to update available_quantity when book quantity changes
DELIMITER //
CREATE TRIGGER trg_book_quantity_update
AFTER UPDATE ON books
FOR EACH ROW
BEGIN
    IF NEW.quantity != OLD.quantity THEN
        UPDATE books SET available_quantity = NEW.quantity - (
            SELECT COUNT(*)
            FROM borrowings
            WHERE book_id = NEW.book_id
            AND status = 'BORROWED'
        )
        WHERE book_id = NEW.book_id;
    END IF;
END//

CREATE TRIGGER trg_book_borrowed
AFTER INSERT ON borrowings
FOR EACH ROW
BEGIN
    UPDATE books SET available_quantity = quantity - (
        SELECT COUNT(*)
        FROM borrowings
        WHERE book_id = NEW.book_id
        AND status = 'BORROWED'
    )
    WHERE book_id = NEW.book_id;
END//
DELIMITER ;