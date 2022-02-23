package co.edu.unbosque.view;

/**
 * Clase extendida de TableManager que permite cambiar el header y funciones de la tabla principal
 */
public class SoldStockPanel extends TableManager {


    /**
     * Metodo que permite cambiar los valores del header por medio de parametros adecuados a panel de cantidad de ventas
     */
    public SoldStockPanel() {
        super(true, "Search", "STOCK_SOLD_SEARCH", new String[]{"INVOICE NUMBER", "STOCK CODE", "DESCRIPTION", "QUANTITY", "INVOICE DATE", "UNIT PRICE", "CUSTOMER ID", "COUNTRY"}, new String[]{"Type a stock code to find:"});
        this.setVisible(false);
    }
}
