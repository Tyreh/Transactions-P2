package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

/**
 * clase MainPanel, el cual permite crear un panel en este caso el panel principal
 */
public class MainPanel extends JPanel {

    /**
     * Objeto array de botones el cual contiene 6 botones
     */
    private final JButton[] buttons = new JButton[5];

    /**
     * Constructor de la clase MainPanel
     */
    public MainPanel() {
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        this.init();
    }

    /**
     * Metodo que permite inicializar cada objeto declarado en el panel
     */
    public void init() {
        String[] buttonNames = {"SUM TOTAL SALES", "FIND BY INVOICE NUMBER", "COUNT BY STOCK CODE", "AVERAGE MONTHLY SALES", "FIND PARTIALLY BY DESCRIPTION"};
        for (int i = 0; i < this.buttons.length; i++) {
            var command = buttonNames[i].replace(" ", "_");
            this.buttons[i] = new JButton(buttonNames[i]);
            this.buttons[i].setActionCommand(command);
            this.add(buttons[i]);
        }
    }

    /**
     * Getters and setters
     */
    public JButton[] getButtons() {
        return buttons;
    }
}
