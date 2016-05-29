package murach.bookcatalog;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        BookManager manager = new BookManager();
        
        List<Book> booksByTitle = manager.getBooksByTitle("Java Programming");
        System.out.println("\nBOOKS BY TITLE:");
        printList(booksByTitle);
        
        List<Book> booksByCategory = manager.getBooksByCategory(Book.JAVA);
        System.out.println("\nBOOKS BY CATEGORY:");
        printList(booksByCategory);
        
        List<Book> booksByFormat = manager.getBooksByFormat(Book.PAPERBACK);
        System.out.println("\nBOOKS BY FORMAT:");
        printList(booksByFormat);
        
    }
    
    public static void printList(List<Book> bookList) {
        for (Book b : bookList) {
            System.out.println(b);
        }
    }
}