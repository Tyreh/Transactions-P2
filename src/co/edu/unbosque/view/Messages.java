package co.edu.unbosque.view;

import javax.swing.*;

/**
 * Clase que permite mostrar mensajes de diferente tipo por medio de JOptionPane
 */
public class Messages {

    public Messages() {

    }
    /**
     * Metodo que permite mostrar un mensaje en pantalla por medio de una ventana emergente
     * @param message, es el escrito que aparece en la ventana emergente
     */
    public static void showInfo(String message) {
        JOptionPane.showMessageDialog(null, message, "Transactions", JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * Metodo que permite mostrar un mensaje de error en pantalla por medio de una ventana emergente
     * @param message, es el escrito que aparece en la ventana emergente
     */
    public static void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "Transactions", JOptionPane.ERROR_MESSAGE);
    }

    /**
     *  Metodo que permite Obtener un mensaje requerido en pantalla por medio de una ventana emergente
     * @param message, es el escrito que aparece en la ventana emergente
     */
    public static String requestString(String message) {
        return JOptionPane.showInputDialog(null, message, "Transactions", JOptionPane.INFORMATION_MESSAGE);
    }
}
