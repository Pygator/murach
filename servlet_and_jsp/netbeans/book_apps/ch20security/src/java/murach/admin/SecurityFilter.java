package murach.admin;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SecurityFilter implements Filter {    
    private FilterConfig filterConfig = null;
    private String[] allowedHosts = null;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        String hostsString = filterConfig.getInitParameter("allowedHosts");
        if (hostsString != null && !hostsString.trim().equals("")) {
            allowedHosts = hostsString.split("\n");
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String remoteAddress = httpRequest.getRemoteAddr();
        boolean allowed = false;
        
        for (String host : allowedHosts) {
            if (host.trim().equals(remoteAddress)) {
                allowed = true;
                break;
            }
        }
        
        if (allowed) {
            chain.doFilter(request, response);
        } else {
            filterConfig.getServletContext()
                    .log("Attempted admin access from unauthorized IP: " +
                        remoteAddress);
            httpResponse.sendError(404);
            // chain.doFilter(request, response);   // this causes an error...
        }
    }

    @Override
    public void destroy() {
        filterConfig = null;
    }
}