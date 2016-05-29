package murach.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// the inner class that implements the listener
public class ClickListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("The button was clicked!");            
    }        
}