package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private final MainPanel mainPanel = new MainPanel();
    private final InvoicePanel invoicePanel = new InvoicePanel();
    private final SoldStockPanel soldStockPanel = new SoldStockPanel();
    private final DescriptionPanel descriptionPanel = new DescriptionPanel();
    private final AveragePanel averagePanel = new AveragePanel();

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
        add(mainPanel, BorderLayout.PAGE_START);
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public InvoicePanel getInvoicePanel() {
        return invoicePanel;
    }

    public SoldStockPanel getSoldStockPanel() {
        return soldStockPanel;
    }

    public DescriptionPanel getDescriptionPanel() {
        return descriptionPanel;
    }

    public AveragePanel getAveragePanel() {
        return averagePanel;
    }
}
