package co.edu.unbosque.view;

public class InvoicePanel extends TableManager {

    public InvoicePanel() {
        super(false, "Search", "INVOICE_SEARCH", new String[]{"INVOICE NUMBER", "STOCK CODE", "DESCRIPTION", "QUANTITY", "INVOICE DATE", "UNIT PRICE", "CUSTOMER ID", "COUNTRY"}, new String[]{"Type a invoice number to find:"});
        this.setVisible(false);
    }
}
