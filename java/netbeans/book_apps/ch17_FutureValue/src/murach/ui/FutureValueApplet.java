package murach.ui;

import javax.swing.JApplet;

public class FutureValueApplet extends JApplet {

    @Override
    public void init() {
        FutureValuePanel panel = new FutureValuePanel();
        this.add(panel);
    }
}