package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * The type Table manager.
 */
public class TableManager extends JPanel {

    /**
     * The Table.
     */
    protected JTable table;
    /**
     * The Scroll table.
     */
    protected JScrollPane scrollTable;
    /**
     * The Default table model.
     */
    protected DefaultTableModel defaultTableModel;

    /**
     * The Text fields array.
     */
    protected JTextField[] textFieldsArray;
    /**
     * The Check boxes array.
     */
    protected JCheckBox[] checkBoxesArray;
    /**
     * The Button.
     */
    protected JButton button;
    /**
     * The Footer label.
     */
    protected JLabel footerLabel;

    public TableManager(boolean footerPanel, String buttonText, String commandButton, String[] columns, String[] fieldLabelArray) {
        this.setLayout(new BorderLayout());

        this.add(headerPanel(buttonText, commandButton, fieldLabelArray), BorderLayout.PAGE_START);
        this.add(centerPanel(columns), BorderLayout.CENTER);

        if (footerPanel) {
            this.add(this.footerPanel(), BorderLayout.PAGE_END);
        }
    }

    public TableManager(boolean footerPanel, String buttonText, Object commandButton, String[] columns, String[] checkBoxLabelArray) {
        this.setLayout(new BorderLayout());

        this.add(headerPanel(buttonText, commandButton, checkBoxLabelArray), BorderLayout.PAGE_START);
        this.add(centerPanel(columns), BorderLayout.CENTER);

        if (footerPanel) {
            this.add(this.footerPanel(), BorderLayout.PAGE_END);
        }
    }

    public TableManager(boolean footerPanel, String buttonText, String commandButton, String[] columns, String[] fieldLabelArray, String[] checkBoxLabelsArray) {
        this.setLayout(new BorderLayout());

        this.add(headerPanel(buttonText, commandButton, fieldLabelArray, checkBoxLabelsArray), BorderLayout.PAGE_START);
        this.add(centerPanel(columns), BorderLayout.CENTER);

        if (footerPanel) {
            this.add(this.footerPanel(), BorderLayout.PAGE_END);
        }
    }


    private JPanel headerPanel(String buttonText, String commandButton, String[] fieldLabelArray) {
        var panel = new JPanel(new FlowLayout());
        this.textFieldsArray = new JTextField[fieldLabelArray.length];
        this.button = new JButton(buttonText);
        this.button.setActionCommand(commandButton);

        for (int i = 0; i < textFieldsArray.length; i++) {
            this.textFieldsArray[i] = new JTextField(10);
            JLabel label = new JLabel(fieldLabelArray[i]);
            panel.add(label);
            panel.add(this.textFieldsArray[i]);
        }
        panel.add(button);
        return panel;
    }

    private JPanel headerPanel(String buttonText, String commandButton, String[] fieldLabelArray, String[] checkBoxLabelArray) {
        var panel = new JPanel(new FlowLayout());
        this.textFieldsArray = new JTextField[fieldLabelArray.length];
        this.checkBoxesArray = new JCheckBox[checkBoxLabelArray.length];
        this.button = new JButton(buttonText);
        this.button.setActionCommand(commandButton);

        for (int i = 0; i < textFieldsArray.length; i++) {
            this.textFieldsArray[i] = new JTextField(10);
            JLabel label = new JLabel(fieldLabelArray[i]);
            panel.add(label);
            panel.add(this.textFieldsArray[i]);
        }

        for (int i = 0; i < checkBoxesArray.length; i++) {
            this.checkBoxesArray[i] = new JCheckBox();
            JLabel label = new JLabel(checkBoxLabelArray[i]);
            panel.add(label);
            panel.add(this.checkBoxesArray[i]);
        }
        panel.add(button);
        return panel;
    }

    private JPanel headerPanel(String buttonText, Object commandButton, String[] checkBoxLabelArray) {
        var panel = new JPanel(new FlowLayout());
        this.checkBoxesArray = new JCheckBox[checkBoxLabelArray.length];
        this.button = new JButton(buttonText);
        this.button.setActionCommand((String) commandButton);

        for (int i = 0; i < checkBoxLabelArray.length; i++) {
            this.checkBoxesArray[i] = new JCheckBox(checkBoxLabelArray[i]);
            panel.add(this.checkBoxesArray[i]);
        }
        panel.add(button);
        return panel;
    }

    private JPanel centerPanel(String[] columns) {
        var panel = new JPanel(new GridLayout());
        this.defaultTableModel = new DefaultTableModel(columns, 0);
        this.table = new JTable(this.defaultTableModel);
        this.table.setEnabled(false);
        this.table.getTableHeader().setReorderingAllowed(false);
        this.scrollTable = new JScrollPane(this.table);
        panel.add(this.scrollTable);
        return panel;
    }

    protected JPanel footerPanel() {
        var panel = new JPanel(new FlowLayout());
        this.footerLabel = new JLabel();
        this.footerLabel.setFont(new Font("", Font.BOLD, 15));
        panel.add(footerLabel);
        return panel;
    }

    /**
     * Gets table.
     *
     * @return the table
     */
    public JTable getTable() {
        return table;
    }

    /**
     * Sets table.
     *
     * @param table the table
     */
    public void setTable(JTable table) {
        this.table = table;
    }

    /**
     * Gets default table model.
     *
     * @return the default table model
     */
    public DefaultTableModel getDefaultTableModel() {
        return defaultTableModel;
    }

    /**
     * Sets default table model.
     *
     * @param defaultTableModel the default table model
     */
    public void setDefaultTableModel(DefaultTableModel defaultTableModel) {
        this.defaultTableModel = defaultTableModel;
    }

    /**
     * Gets scroll table.
     *
     * @return the scroll table
     */
    public JScrollPane getScrollTable() {
        return scrollTable;
    }

    /**
     * Sets scroll table.
     *
     * @param scrollTable the scroll table
     */
    public void setScrollTable(JScrollPane scrollTable) {
        this.scrollTable = scrollTable;
    }

    /**
     * Gets button.
     *
     * @return the button
     */
    public JButton getButton() {
        return button;
    }

    /**
     * Sets button.
     *
     * @param button the button
     */
    public void setButton(JButton button) {
        this.button = button;
    }

    /**
     * Gets footer label.
     *
     * @return the footer label
     */
    public JLabel getFooterLabel() {
        return footerLabel;
    }

    /**
     * Sets footer label.
     *
     * @param footerLabel the footer label
     */
    public void setFooterLabel(JLabel footerLabel) {
        this.footerLabel = footerLabel;
    }

    /**
     * Get text fields array j text field [ ].
     *
     * @return the j text field [ ]
     */
    public JTextField[] getTextFieldsArray() {
        return textFieldsArray;
    }

    /**
     * Sets text fields array.
     *
     * @param textFieldsArray the text fields array
     */
    public void setTextFieldsArray(JTextField[] textFieldsArray) {
        this.textFieldsArray = textFieldsArray;
    }

    /**
     * Get check boxes array j check box [ ].
     *
     * @return the j check box [ ]
     */
    public JCheckBox[] getCheckBoxesArray() {
        return checkBoxesArray;
    }

    /**
     * Sets check boxes array.
     *
     * @param checkBoxesArray the check boxes array
     */
    public void setCheckBoxesArray(JCheckBox[] checkBoxesArray) {
        this.checkBoxesArray = checkBoxesArray;
    }
}
