package co.edu.unbosque.view;

import javax.swing.*;

public class SoldStockPanel extends TableManager {

    private JLabel amountSold;

    public SoldStockPanel() {
        super(true, new String[]{"INVOICE NUMBER", "STOCK CODE", "DESCRIPTION", "QUANTITY", "INVOICE DATE", "UNIT PRICE", "CUSTOMER ID", "COUNTRY"});
        this.setVisible(false);
        this.addComponentsFormat();
    }

    private void addComponentsFormat() {
        this.label.setText("Type a stock code to find: ");
        this.button.setText("Search");
        this.button.setActionCommand("STOCK_SOLD_SEARCH");
    }
}
