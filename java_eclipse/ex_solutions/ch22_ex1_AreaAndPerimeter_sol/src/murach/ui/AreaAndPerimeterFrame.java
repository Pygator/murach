package murach.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import murach.business.Rectangle;

@SuppressWarnings("serial")
public class AreaAndPerimeterFrame extends JFrame {

    private JTextField lengthField;
    private JTextField widthField;
    private JTextField areaField;
    private JTextField perimeterField;
    private JButton computeButton;
    private JButton resetButton;

    public AreaAndPerimeterFrame() {
        // Optional. Sets look and feel to platform native.
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e);
        }
        initComponents();
        setTitle("Area and Perimeter Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setVisible(true);
    }

    private void initComponents() {
        lengthField = new JTextField();
        widthField = new JTextField();
        areaField = new JTextField();
        perimeterField = new JTextField();

        areaField.setEditable(false);
        perimeterField.setEditable(false);

        Dimension dim = new Dimension(250, 20);
        lengthField.setPreferredSize(dim);
        widthField.setPreferredSize(dim);
        areaField.setPreferredSize(dim);
        perimeterField.setPreferredSize(dim);
        lengthField.setMinimumSize(dim);
        widthField.setMinimumSize(dim);
        areaField.setMinimumSize(dim);
        perimeterField.setMinimumSize(dim);

        computeButton = new JButton("Compute");
        resetButton = new JButton("Reset");

        computeButton.addActionListener((ActionEven) -> {
            computeButtonClicked();
        });
        resetButton.addActionListener((ActionEven) -> {
            resetButtonClicked();
        });

        //JLabel and JTextField panel
        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(new GridBagLayout());
        dataPanel.add(new JLabel("Length:"),
                getConstraints(0, 0, GridBagConstraints.LINE_END));
        dataPanel.add(lengthField,
                getConstraints(1, 0, GridBagConstraints.LINE_START));
        dataPanel.add(new JLabel("Width:"),
                getConstraints(0, 1, GridBagConstraints.LINE_END));
        dataPanel.add(widthField,
                getConstraints(1, 1, GridBagConstraints.LINE_START));
        dataPanel.add(new JLabel("Area:"),
                getConstraints(0, 2, GridBagConstraints.LINE_END));
        dataPanel.add(areaField,
                getConstraints(1, 2, GridBagConstraints.LINE_START));
        dataPanel.add(new JLabel("Perimeter:"),
                getConstraints(0, 3, GridBagConstraints.LINE_END));
        dataPanel.add(perimeterField,
                getConstraints(1, 3, GridBagConstraints.LINE_START));
        add(dataPanel, BorderLayout.CENTER);

        // JButton panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(computeButton);
        buttonPanel.add(resetButton);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
    }

    // Helper method to return GridBagConstraints objects
    private GridBagConstraints getConstraints(int x, int y, int anchor) {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 0, 5);
        c.gridx = x;
        c.gridy = y;
        c.anchor = anchor;
        return c;
    }

    private void computeButtonClicked() {
        double length;
        double width;
        try {
            length = Double.parseDouble(lengthField.getText());
            width = Double.parseDouble(widthField.getText());

            Rectangle r = new Rectangle(length, width);
            areaField.setText(r.getAreaNumberFormat());
            perimeterField.setText(r.getPerimeterNumberFormat());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "The length or width is an invalid number. Please try again.",
                    "Invalid Number", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void resetButtonClicked() {
        lengthField.setText("");
        widthField.setText("");
        areaField.setText("");
        perimeterField.setText("");
    }
}
