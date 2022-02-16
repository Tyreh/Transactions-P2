package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private MainPanel mainPanel;
    private InvoicePanel invoicePanel;
    private SoldStockPanel soldStockPanel;
    private DescriptionPanel descriptionPanel;

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

        invoicePanel = new InvoicePanel();
        soldStockPanel = new SoldStockPanel();
        descriptionPanel = new DescriptionPanel();
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public InvoicePanel getInvoicePanel() {
        return invoicePanel;
    }

    public void setInvoicePanel(InvoicePanel invoicePanel) {
        this.invoicePanel = invoicePanel;
    }

    public SoldStockPanel getSoldStockPanel() {
        return soldStockPanel;
    }

    public void setSoldStockPanel(SoldStockPanel soldStockPanel) {
        this.soldStockPanel = soldStockPanel;
    }

    public DescriptionPanel getDescriptionPanel() {
        return descriptionPanel;
    }

    public void setDescriptionPanel(DescriptionPanel descriptionPanel) {
        this.descriptionPanel = descriptionPanel;
    }
}

