package murach.bookcatalog;

public class Book {
    public static final String JAVA = "Java";
    public static final String DOTNET = ".NET";
    public static final String WEB = "Web";
    public static final String DATABASE = "Database";
    public static final String MOBILE = "Mobile";
    
    public static final String PAPERBACK = "Paperback";
    public static final String ELECTRONIC = "Electronic";
    
    private String title;
    private String category;
    private String format;
    
    public Book(String title, String category, String format) {
        this.title = title;
        this.category = category;
        this.format = format;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public String getFormat() {
        return format;
    }
    
    public void setFormat(String format) {
        this.format = format;
    }
    
    @Override
    public String toString() {
        return "[" + getTitle()    + ", "
                   + getCategory() + ", "
                   + getFormat() + "]";
    }
}