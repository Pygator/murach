package murach.bookcatalog;

import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private List<Book> bookList;
    
    public BookManager() {
        bookList = new BookCatalog().getCatalog();
    }
    
    public List<Book> getBooksByTitle(String title) {
        List<Book> books = new ArrayList<>();
        for (Book b : bookList) {
            if (b.getTitle().equals(title)) {
                books.add(b);
            }
        }
        return books;
    }
    
    public List<Book> getBooksByCategory(String category) {
        List<Book> books = new ArrayList<>();
        for (Book b : bookList) {
            if (b.getCategory().equals(category)) {
                books.add(b);
            }
        }
        return books;
    }
    
    public List<Book> getBooksByFormat(String format) {
        List<Book> books = new ArrayList<>();
        for (Book b : bookList) {
            if (b.getFormat().equals(format)) {
                books.add(b);
            }
        }
        return books;
    }
}