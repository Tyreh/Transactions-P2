package co.edu.unbosque.view;

/**
 * lase extendida de TableManager que permite cambiar el header y funciones de la tabla principal
 */
public class DescriptionPanel extends TableManager {

    /**
     * Metodo que permite cambiar los valores del header por medio de parametros adecuados a panel de descripcion
     */
    public DescriptionPanel() {
        super(false, "Search", "DESCRIPTION_SEARCH", new String[]{"INVOICE NUMBER", "STOCK CODE", "DESCRIPTION", "QUANTITY", "INVOICE DATE", "UNIT PRICE", "CUSTOMER ID", "COUNTRY"}, new String[]{"Type a word to find: ", "Init month: ", "End month:"}, new String[]{"Order"});
        this.setVisible(false);
    }
}
