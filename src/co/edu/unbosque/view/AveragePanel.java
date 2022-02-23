package co.edu.unbosque.view;

/**
 * Clase extendida de TableManager que permite cambiar el header y funciones de la tabla principal
 */
public class AveragePanel extends TableManager {

    /**
     * Metodo que permite cambiar los valores del header por medio de parametros adecuados a panel de promedio
     */
    public AveragePanel() {
        super(false, "Search", (Object) "AVERAGE_SEARCH",
                new String[]{"COUNTRY","JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"},
                new String[]{"Group by country"});
        this.setVisible(false);
    }


}
