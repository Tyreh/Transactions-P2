package co.edu.unbosque.view;

public class AveragePanel extends TableManager {

    public AveragePanel() {
        super(false, "Search", (Object) "AVERAGE_SEACH",
                new String[]{"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"},
                new String[]{"Group by country"});
        this.setVisible(false);
    }
}
