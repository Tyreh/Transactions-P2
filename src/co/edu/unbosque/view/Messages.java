package co.edu.unbosque.view;

import javax.swing.*;

/**
 * The type Messages.
 */
public class Messages {

    /**
     * Instantiates a new Messages.
     */
    public Messages() {

    }

    /**
     * Show info.
     *
     * @param message the message
     */
    public static void showInfo(String message) {
        JOptionPane.showMessageDialog(null, message, "Transactions", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Show error.
     *
     * @param message the message
     */
    public static void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "Transactions", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Request string string.
     *
     * @param message the message
     * @return the string
     */
    public static String requestString(String message) {
        return JOptionPane.showInputDialog(null, message, "Transactions", JOptionPane.INFORMATION_MESSAGE);
    }
}
