package co.edu.unbosque.view;

public class SoldStockPanel extends TableManager {

    public SoldStockPanel() {
        super(true, "Search", "STOCK_SOLD_SEARCH", new String[]{"INVOICE NUMBER", "STOCK CODE", "DESCRIPTION", "QUANTITY", "INVOICE DATE", "UNIT PRICE", "CUSTOMER ID", "COUNTRY"}, new String[]{"Type a stock code to find:"});
        this.setVisible(false);
    }
}
