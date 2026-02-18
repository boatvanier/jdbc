package org.example.lab.forTestLab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookServiceTest {
    private BookService bookService;

    @BeforeEach
    void setup() {
        bookService = new BookService();
    }

    @Test
    void testIsAvailable_whenStockGreaterThanZero() {
        assertTrue(bookService.isAvailable(5));
    }
    @Test
    void testIsAvailable_whenStockLessThanZero() {
        assertFalse(bookService.isAvailable(-3));
    }
    @Test
    void testIsAvailable_whenStockZero() {
        assertFalse(bookService.isAvailable(0));
    }

    @Test
    void testBookBorrow_canBorrow() {
        assertDoesNotThrow(()->bookService.borrowBook(3));
    }
    @Test
    void testBookBorrow_whenStoreIsZero() {
        assertThrows(IllegalStateException.class, ()->bookService.borrowBook(0));
    }
    @Test
    void testBookBorrow_whenStockLessThanZero() {
        assertThrows(IllegalStateException.class, ()->bookService.borrowBook(-1));
    }

}
