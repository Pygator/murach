package murach.test;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class MessageBean {
    private String message = "<h1>Hello, world!</h1>";
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }    
}