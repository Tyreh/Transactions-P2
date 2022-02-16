package co.edu.unbosque.view;

public class InvoicePanel extends TableManager {

    public InvoicePanel() {
        super(false, new String[]{"INVOICE NUMBER", "STOCK CODE", "DESCRIPTION", "QUANTITY", "INVOICE DATE", "UNIT PRICE", "CUSTOMER ID", "COUNTRY"});
        this.setVisible(false);
        this.addComponentsFormat();
    }

    private void addComponentsFormat() {
        this.label.setText("Type a invoice number to find: ");
        this.button.setText("Search");
        this.button.setActionCommand("INVOICE_SEARCH");
    }
}
