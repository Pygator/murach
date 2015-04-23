import java.io.*;

public class ResourcesTesterApp
{
    public static void main(String[] args)
    {
        String s1 = readLineWithResources();
        String s2 = readLineWithFinally();
    }

    public static String readLineWithResources()
    {
        System.out.println("Starting readLineWithResources method.");
        
        try
        {
            RandomAccessFile in = new RandomAccessFile("products.ran", "r");
            String s = in.readLine();
            return s;
        } 
        catch (IOException e)
        {
            System.out.println(e.toString());
            return null;
        }
    }
            
    public static String readLineWithFinally()
    {
        System.out.println("Starting readLineWithFinally method.");
        
        try
        {
            RandomAccessFile in = new RandomAccessFile("products.ran", "r");
            String s = in.readLine();
            return s;
        } 
        catch (IOException e)
        {
            System.out.println(e.toString());
            return null;
        }
    }    
}