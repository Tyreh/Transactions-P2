package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

/**
 * The type Main frame.
 */
public class MainFrame extends JFrame {

    /**
     * MainPanel class object, which allows the main panel to be obtained and displayed
     */
    private final MainPanel mainPanel = new MainPanel();
    /**
     * Object of the InvoicePanel class, which allows to obtain the invoicing panel.
     */
    private final InvoicePanel invoicePanel = new InvoicePanel();
    /**
     * Object of the SoldStockPanel class, which allows to obtain the sold quantity panel.
     */
    private final SoldStockPanel soldStockPanel = new SoldStockPanel();
    /**
     * Object of the DescriptioPanel class, which allows to obtain the description panel.
     */
    private final DescriptionPanel descriptionPanel = new DescriptionPanel();
    /**
     * Object of the AveragePanel class, which allows to obtain the average panel.
     */
    private final AveragePanel averagePanel = new AveragePanel();

    /**
     * Instantiates a new Main frame.
     */
    public MainFrame() {
        setTitle("Transactions");
        setSize(1000, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        init();
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
    }

    /**
     * Init.
     */
    public void init() {
        add(mainPanel, BorderLayout.PAGE_START);
    }


    /**
     * Gets main panel.
     *
     * @return the main panel
     */
    public MainPanel getMainPanel() {
        return mainPanel;
    }

    /**
     * Gets invoice panel.
     *
     * @return the invoice panel
     */
    public InvoicePanel getInvoicePanel() {
        return invoicePanel;
    }

    /**
     * Gets sold stock panel.
     *
     * @return the sold stock panel
     */
    public SoldStockPanel getSoldStockPanel() {
        return soldStockPanel;
    }

    /**
     * Gets description panel.
     *
     * @return the description panel
     */
    public DescriptionPanel getDescriptionPanel() {
        return descriptionPanel;
    }

    /**
     * Gets average panel.
     *
     * @return the average panel
     */
    public AveragePanel getAveragePanel() {
        return averagePanel;
    }
}
