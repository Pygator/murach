package murach.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import murach.business.Product;
import murach.db.DBException;
import murach.db.ProductDB;

@SuppressWarnings("serial")
public class ProductForm extends JDialog {
    private JTextField codeField;
    private JTextField descriptionField;
    private JTextField priceField;
    private JButton confirmButton;
    private JButton cancelButton;

    private Product product = new Product();

    public ProductForm(java.awt.Frame parent, String title, boolean modal) {
        super(parent, title, modal);
        initComponents();
    }
    
    public ProductForm(java.awt.Frame parent, String title,
            boolean modal, Product product) {
        this(parent, title, modal);        
        this.product = product;
        confirmButton.setText("Save");
        codeField.setText(product.getCode());
        descriptionField.setText(product.getDescription());
        priceField.setText(Double.toString(product.getPrice()));
    }

    private void initComponents() {
        codeField = new JTextField();
        descriptionField = new JTextField();
        priceField = new JTextField();
        cancelButton = new JButton();
        confirmButton = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);     
        
        Dimension shortField = new Dimension(100, 20);
        Dimension longField = new Dimension(300, 20);
        codeField.setPreferredSize(shortField);
        codeField.setMinimumSize(shortField);        
        priceField.setPreferredSize(shortField);
        priceField.setMinimumSize(shortField);        
        descriptionField.setPreferredSize(longField);
        descriptionField.setMinimumSize(longField);
        
        cancelButton.setText("Cancel");
        cancelButton.addActionListener((ActionEvent) -> {
            cancelButtonActionPerformed();
        });

        confirmButton.setText("Add");
        confirmButton.addActionListener((ActionEvent) -> {
            confirmButtonActionPerformed();
        });

        // JLabel and JTextField panel
        JPanel productPanel = new JPanel();
        productPanel.setLayout(new GridBagLayout());
        productPanel.add(new JLabel("Code:"), 
                getConstraints(0, 0, GridBagConstraints.LINE_END));
        productPanel.add(codeField,
                getConstraints(1, 0, GridBagConstraints.LINE_START));
        productPanel.add(new JLabel("Description:"), 
                getConstraints(0, 1, GridBagConstraints.LINE_END));
        productPanel.add(descriptionField, 
                getConstraints(1, 1, GridBagConstraints.LINE_START));
        productPanel.add(new JLabel("Price:"), 
                getConstraints(0, 2, GridBagConstraints.LINE_END));
        productPanel.add(priceField, 
                getConstraints(1, 2, GridBagConstraints.LINE_START));

        // JButton panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);

        // add panels to main panel
        setLayout(new BorderLayout());
        add(productPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        pack();        
    }
    
    private GridBagConstraints getConstraints(int x, int y, int anchor) {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 0, 5);
        c.gridx = x;
        c.gridy = y;
        c.anchor = anchor;
        return c;
    }

    private void cancelButtonActionPerformed() {                                             
        dispose();
    }                                            

    private void confirmButtonActionPerformed() {
        if (validateData()) {
            setData();
            if (confirmButton.getText().equals("Add")) {
                doAdd();
            } else {
                doEdit();
            }
        }
    }
    
    private boolean validateData() {
        String code = codeField.getText();
        String name = descriptionField.getText();
        String priceString = priceField.getText();
        if (code == null || name == null || priceString == null ||
                code.isEmpty() || name.isEmpty() || priceString.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.",
                    "Missing Fields", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else {
            try {
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,
                        "The data entered in the price field is invalid",
                        "Invalid Price",
                        JOptionPane.INFORMATION_MESSAGE);
                priceField.requestFocusInWindow();
                return false;
            }
        }
        return true;
    }
    
    private void setData() {
        String code = codeField.getText();
        String name = descriptionField.getText();
        String priceString = priceField.getText();
        double price = Double.parseDouble(priceString);
        product.setCode(code);
        product.setDescription(name);
        product.setPrice(price);
    }
    
    private void doEdit() {
        try {
            ProductDB.update(product);
            dispose();
            fireDatabaseUpdatedEvent();
        } catch (DBException e) {
            System.out.println(e);
        }
    }
    
    private void doAdd() {
        try {
            ProductDB.add(product);
            dispose();
            fireDatabaseUpdatedEvent();
        } catch(DBException e) {
            System.out.println(e);
        }
    }
    
    private void fireDatabaseUpdatedEvent() {
        ProductManagerFrame mainWindow = (ProductManagerFrame) getOwner();
        mainWindow.fireDatabaseUpdatedEvent();
    }
}