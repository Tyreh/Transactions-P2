package co.edu.unbosque.view;


/**
 * The type Average panel.
 */
public class AveragePanel extends TableManager {


    /**
     * Instantiates a new Average panel.
     */
    public AveragePanel() {
        super(false, "Search", (Object) "AVERAGE_SEARCH",
                new String[]{"COUNTRY","JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"},
                new String[]{"Group by country"});
        this.setVisible(false);
    }


}
