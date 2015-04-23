package murach.filters;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LogResponseFilter implements Filter {

    private FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(
            ServletRequest request, 
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        
        chain.doFilter(request, response);

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        ServletContext sc = filterConfig.getServletContext();

        String logString = filterConfig.getFilterName() + " | ";
        logString += "Servlet path: " + httpRequest.getServletPath() + " | ";
        logString += "Content type: " + httpResponse.getContentType();

        sc.log(logString);
    }

    @Override
    public void destroy() {
        filterConfig = null;
    }
}