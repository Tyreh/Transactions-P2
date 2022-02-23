package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

/**
 * The type Main frame.
 */
public class MainFrame extends JFrame {

    /**
     * Objeto de la clase MainPanel, que permite obtener el panel principal y mostrarlo
     */
    private final MainPanel mainPanel = new MainPanel();
    /**
     * Objeto de la clase InvoicePanel, que permite obtener el panel de facturacion
     */
    private final InvoicePanel invoicePanel = new InvoicePanel();
    /**
     * Objeto de la clase SoldStockPanel, que permite obtener el panel de cantidad vendido
     */
    private final SoldStockPanel soldStockPanel = new SoldStockPanel();
    /**
     * Objeto de la clase DescriptioPanel, que permite obtener el panel de descripcion
     */
    private final DescriptionPanel descriptionPanel = new DescriptionPanel();
    /**
     * Objeto de la clase AveragePanel, que permite obtener el panel de promedio
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
        setResizable(false);
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
