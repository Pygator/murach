package murach.bookcatalog;

import java.util.ArrayList;
import java.util.List;

public class BookCatalog {
    private List<Book> bookCatalog;
    
    public BookCatalog() {
        bookCatalog = new ArrayList<>();
        bookCatalog.add(new Book("PHP and MySQL", Book.WEB, Book.ELECTRONIC));
        bookCatalog.add(new Book("MySQL", Book.DATABASE, Book.PAPERBACK));
        bookCatalog.add(new Book("MySQL", Book.DATABASE, Book.ELECTRONIC));
        bookCatalog.add(new Book("Dreamweaver", Book.WEB, Book.ELECTRONIC));
        bookCatalog.add(new Book("Java Servlets and JSP", Book.JAVA, Book.PAPERBACK));
        bookCatalog.add(new Book("Java Servlets and JSP", Book.JAVA, Book.ELECTRONIC));
        bookCatalog.add(new Book("C# 2012", Book.DOTNET, Book.ELECTRONIC));
        bookCatalog.add(new Book("Visual Basic 2012", Book.DOTNET, Book.ELECTRONIC));
        bookCatalog.add(new Book("SQL Server 2012", Book.DATABASE, Book.ELECTRONIC));
        bookCatalog.add(new Book("Oracle SQL and PL/SQL", Book.DATABASE, Book.ELECTRONIC));
        bookCatalog.add(new Book("HTML5 and CSS3", Book.WEB, Book.ELECTRONIC));
        bookCatalog.add(new Book("JavaScript and jQuery", Book.WEB, Book.ELECTRONIC));
        bookCatalog.add(new Book("Java Programming", Book.JAVA, Book.PAPERBACK));
        bookCatalog.add(new Book("Java Programming", Book.JAVA, Book.ELECTRONIC));
        bookCatalog.add(new Book("Android Programming", Book.MOBILE, Book.PAPERBACK));
        bookCatalog.add(new Book("Android Programming", Book.MOBILE, Book.ELECTRONIC));
        bookCatalog.add(new Book("JavaScript and DOM Scripting", Book.WEB, Book.ELECTRONIC));
    }
    
    public List<Book> getCatalog() {
        return bookCatalog;
    }
}