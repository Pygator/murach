package murach.fv;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

@SuppressWarnings("serial")
public class FutureValueFrame extends JFrame {

    private JTextField monthlyInvestmentField;
    private JTextField yearlyInterestRateField;
    private JTextField yearsField;
    private JTextField futureValueField;
    private JButton calculateButton;
    private JButton exitButton;

    public FutureValueFrame() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e);
        }
        initComponents();
        setTitle("Future Value Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setVisible(true);
    }

    private void initComponents() {
        monthlyInvestmentField = new JTextField();
        yearlyInterestRateField = new JTextField();
        yearsField = new JTextField();
        futureValueField = new JTextField();

        futureValueField.setEditable(false);

        Dimension dim = new Dimension(150, 20);
        monthlyInvestmentField.setPreferredSize(dim);
        yearlyInterestRateField.setPreferredSize(dim);
        yearsField.setPreferredSize(dim);
        futureValueField.setPreferredSize(dim);
        monthlyInvestmentField.setMinimumSize(dim);
        yearlyInterestRateField.setMinimumSize(dim);
        yearsField.setMinimumSize(dim);
        futureValueField.setMinimumSize(dim);

        calculateButton = new JButton("Calculate");
        exitButton = new JButton("Exit");

        calculateButton.addActionListener((ActionEven) -> {
            computeButtonClicked();
        });
        exitButton.addActionListener((ActionEven) -> {
            exitButtonClicked();
        });

        //JLabel and JTextField panel
        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(new GridBagLayout());
        dataPanel.add(new JLabel("Monthly Investment:"),
                getConstraints(0, 0, GridBagConstraints.LINE_START));
        dataPanel.add(monthlyInvestmentField,
                getConstraints(1, 0, GridBagConstraints.LINE_START));
        dataPanel.add(new JLabel("Yearly Interest Rate:"),
                getConstraints(0, 1, GridBagConstraints.LINE_START));
        dataPanel.add(yearlyInterestRateField,
                getConstraints(1, 1, GridBagConstraints.LINE_START));
        dataPanel.add(new JLabel("Years:"),
                getConstraints(0, 2, GridBagConstraints.LINE_START));
        dataPanel.add(yearsField,
                getConstraints(1, 2, GridBagConstraints.LINE_START));
        dataPanel.add(new JLabel("Future Value:"),
                getConstraints(0, 3, GridBagConstraints.LINE_START));
        dataPanel.add(futureValueField,
                getConstraints(1, 3, GridBagConstraints.LINE_START));
        add(dataPanel, BorderLayout.CENTER);

        // JButton panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(calculateButton);
        buttonPanel.add(exitButton);
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
        double monthlyInvestment;
        double yearlyInterestRate;
        int years;
        try {
            monthlyInvestment = Double.parseDouble(monthlyInvestmentField.getText());
            yearlyInterestRate = Double.parseDouble(yearlyInterestRateField.getText());
            years = Integer.parseInt(yearsField.getText());
            
            double futureValue = Financial.calculateFutureValue(
                    monthlyInvestment, yearlyInterestRate, years);
            
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            futureValueField.setText(currency.format(futureValue));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "You have entered an invalid number. Please try again.",
                    "Invalid Number", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void exitButtonClicked() {
        System.exit(0);
    }
}