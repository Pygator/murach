public class DBUtils
{
    // handle strings that contain one or more single quotes (')
    public static String fixDBString(String s)
    {
        // if the string is null, return it
        if (s == null)
            return s;

        // add a single quote immediately before it
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++)
        {
            char ch = sb.charAt(i);
            if (ch == 39)  //39 is the ASCII code for a single quote
                sb.insert(i++, "'");
        }
        return sb.toString();
    }
}