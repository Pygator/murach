package murach.tags;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.util.*;
import java.text.DateFormat;

public class CurrentTimeTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        
        Date currentTime = new Date();
        DateFormat shortDate = DateFormat.getTimeInstance(DateFormat.LONG);
        String currentTimeFormatted = shortDate.format(currentTime);

        try {
            JspWriter out = pageContext.getOut();
            out.print(currentTimeFormatted);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        return SKIP_BODY;
    }
}