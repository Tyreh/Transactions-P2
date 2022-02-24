package co.edu.unbosque.view;


/**
 * The type Description panel.
 */
public class DescriptionPanel extends TableManager {


    /**
     * Instantiates a new Description panel.
     */
    public DescriptionPanel() {
        super(false, "Search", "DESCRIPTION_SEARCH", new String[]{"INVOICE NUMBER", "STOCK CODE", "DESCRIPTION", "QUANTITY", "INVOICE DATE", "UNIT PRICE", "CUSTOMER ID", "COUNTRY"}, new String[]{"Type a word to find: ", "Init month: ", "End month:"}, new String[]{"Order"});
        this.setVisible(false);
    }
}
