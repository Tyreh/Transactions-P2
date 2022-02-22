package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que permite crear el frame principal de la vista
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
     * Constructor de la clase
     */
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

    /**
     * Metodo que permite iniciar cada objeto en el frame
     */
    public void init() {
        add(mainPanel, BorderLayout.PAGE_START);
    }

    /**
     * Getter and Setters
     */
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
