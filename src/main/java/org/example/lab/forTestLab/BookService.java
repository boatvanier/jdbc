package org.example.lab.forTestLab;

public class BookService {
    public boolean isAvailable(int stock) {
        return stock > 0;
    }
    public void borrowBook(int stock) {
        if (stock <= 0) {
            throw new IllegalStateException("Book not available");
        }
    }
}