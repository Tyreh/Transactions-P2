package co.edu.unbosque.view;

/**
 * Clase extendida de TableManager que permite cambiar el header y funciones de la tabla principal
 */
public class InvoicePanel extends TableManager {

    /**
     * Metodo que permite cambiar los valores del header por medio de parametros adecuados a panel de facturacion
     */
    public InvoicePanel() {
        super(false, "Search", "INVOICE_SEARCH", new String[]{"INVOICE NUMBER", "STOCK CODE", "DESCRIPTION", "QUANTITY", "INVOICE DATE", "UNIT PRICE", "CUSTOMER ID", "COUNTRY"}, new String[]{"Type a invoice number to find:"});
        this.setVisible(false);
    }
}
