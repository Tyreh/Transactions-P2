package co.edu.unbosque.view;

import javax.swing.*;

public class Messages {

    public Messages() {

    }

    public static void showInfo(String message) {
        JOptionPane.showMessageDialog(null, message, "Transactions", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "Transactions", JOptionPane.ERROR_MESSAGE);
    }

    public static String requestString(String message) {
        return JOptionPane.showInputDialog(null, message, "Transactions", JOptionPane.INFORMATION_MESSAGE);
    }
}
