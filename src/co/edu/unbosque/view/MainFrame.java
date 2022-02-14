package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private MainPanel mainPanel;

    public MainFrame() {
        setTitle("Transactions");
        setSize(1000,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        init();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void init() {
        mainPanel = new MainPanel();
        add(mainPanel, BorderLayout.PAGE_START);

    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }
}
