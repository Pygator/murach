import javax.swing.JFrame;

public class ProductFrame extends JFrame
{
    public ProductFrame()
    {
        // all of these methods are available because
        // they are inherited from the JFrame class
        // and its superclasses

        this.setTitle("Product");
        this.setSize(200, 200);
        this.setLocation(10, 10);
        this.setResizable(false);

        // this method uses a field that's available
        // because it's inherited
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args)
    {
        // this creates an instance of the ProductFrame
        JFrame frame = new ProductFrame();

        // this displays the frame
        frame.setVisible(true);
    }
}