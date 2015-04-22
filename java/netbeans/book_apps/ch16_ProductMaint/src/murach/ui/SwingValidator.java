package murach.ui;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.math.BigDecimal;

public class SwingValidator
{
    public boolean isPresent(JTextComponent c, String title)
    {
        if (c.getText().length() == 0)
        {
            showMessage(c, title + " is a required field.\n");
            c.requestFocusInWindow();
            return false;
        }
        return true;
    }

    public boolean isInteger(JTextComponent c, String title)
    {
        try
        {
            Integer.parseInt(c.getText());
            return true;
        }
        catch (NumberFormatException e)
        {
            showMessage(c, title + " must be an integer.\n");
            c.requestFocusInWindow();
            return false;
        }
    }

    public boolean isDouble(JTextComponent c, String title)
    {
        try
        {
            Double.parseDouble(c.getText());
            return true;
        }
        catch (NumberFormatException e)
        {
            showMessage(c, title + " must be a valid number.\n");
            c.requestFocusInWindow();
            return false;
        }
    }

    public boolean isDecimal(JTextComponent c, String title)
    {
        try
        {
            BigDecimal bd = new BigDecimal(c.getText());
            return true;
        }
        catch (NumberFormatException e)
        {
            showMessage(c, title + " must be a valid number.\n");
            c.requestFocus();
            return false;
        }
    }

    public boolean isWithinRange(JTextComponent c, double min, double max, String title)
    {
        double d = Double.parseDouble(c.getText());
        if (d < min | d > max)
        {
            showMessage(c, title + " must be between " + min + " and " + max + ".\n");
            c.requestFocusInWindow();
            return false;
        }
        return true;
    }

    private void showMessage(JTextComponent c, String message)
    {
            JOptionPane.showMessageDialog(c, message, "Invalid Entry",
                JOptionPane.ERROR_MESSAGE);
    }
}