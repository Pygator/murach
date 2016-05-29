package murach.test;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TestFrame extends JFrame {
    
    public TestFrame() {
        // code that sets up the frame
        this.setTitle("Test Frame");
        this.setSize(400, 100);
        this.setLocationByPlatform(true);        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        this.add(panel);
        
        // code that creates the button and adds the listener
        JButton button1 = new JButton("Test Button");
        ActionListener listener = new ClickListener();
        button1.addActionListener(listener);

        // code that displays the frame
        panel.add(button1);
        this.setVisible(true);        
    }
}