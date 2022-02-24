package co.edu.unbosque.view;

/**
 * The type Invoice panel.
 */
public class InvoicePanel extends TableManager {

    /**
     * Instantiates a new Invoice panel.
     */
    public InvoicePanel() {
        super(false, "Search", "INVOICE_SEARCH", new String[]{"INVOICE NUMBER", "STOCK CODE", "DESCRIPTION", "QUANTITY", "INVOICE DATE", "UNIT PRICE", "CUSTOMER ID", "COUNTRY"}, new String[]{"Type a invoice number to find:"});
        this.setVisible(false);
    }
}
