import java.io.*;

public class IOStringUtils
{
    public static void writeFixedString(DataOutput out, int length,
    String s) throws IOException
    {
        for (int i = 0; i < length; i++)
        {
            if (i < s.length())
                out.writeChar(s.charAt(i)); // write char
            else
                out.writeChar(0);           // write Unicode zero
        }
    }

    public static String readFixedString(DataInput in, int length)
    throws IOException
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++)
        {
            char c = in.readChar();
            // if char is not Unicode zero add to string
            if (c != 0)
                sb.append(c);
        }
        return sb.toString();
    }
}