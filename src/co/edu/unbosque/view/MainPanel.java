package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    private final JButton[] buttons = new JButton[5];

    public MainPanel() {
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        this.init();
    }

    public void init() {
        String[] buttonNames = {"SUM TOTAL SALES", "FIND BY INVOICE NUMBER", "COUNT BY STOCK CODE", "AVERAGE MONTHLY SALES", "FIND PARTIALLY BY DESCRIPTION"};
        for (int i = 0; i < this.buttons.length; i++) {
            var command = buttonNames[i].replace(" ", "_");
            this.buttons[i] = new JButton(buttonNames[i]);
            this.buttons[i].setActionCommand(command);
            this.add(buttons[i]);
        }
    }

    public JButton[] getButtons() {
        return buttons;
    }
}
