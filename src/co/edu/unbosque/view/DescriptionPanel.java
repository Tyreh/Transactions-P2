package co.edu.unbosque.view;

public class DescriptionPanel extends TableManager {

    public DescriptionPanel() {
        super(true, new String[]{"INVOICE NUMBER", "STOCK CODE", "DESCRIPTION", "QUANTITY", "INVOICE DATE", "UNIT PRICE", "CUSTOMER ID", "COUNTRY"});
        this.setVisible(false);
        this.addComponentsFormat();
    }

    private void addComponentsFormat() {
        this.label.setText("Type a description word to find: ");
        this.button.setText("Search");
        this.button.setActionCommand("DESCRIPTION_SEARCH");
    }
}
