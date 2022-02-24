package co.edu.unbosque.view;

/**
 * The type Sold stock panel.
 */
public class SoldStockPanel extends TableManager {

    /**
     * Instantiates a new Sold stock panel.
     */
    public SoldStockPanel() {
        super(true, "Search", "STOCK_SOLD_SEARCH", new String[]{"INVOICE NUMBER", "STOCK CODE", "DESCRIPTION", "QUANTITY", "INVOICE DATE", "UNIT PRICE", "CUSTOMER ID", "COUNTRY"}, new String[]{"Type a stock code to find:"});
        this.setVisible(false);
    }
}
