package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

/**
 * MainPanel class, which allows you to create a panel, in this case the main panel.
 */
public class MainPanel extends JPanel {

    /**
     * Object array of buttons which contains 6 buttons
     */
    private final JButton[] buttons = new JButton[5];

    /**
     * MainPanel class constructor
     */
    public MainPanel() {
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        this.init();
    }

    /**
     * Method to initialize each object declared in the panel.
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
