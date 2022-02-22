package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TableManager extends JPanel {

    protected JTable table;
    protected JScrollPane scrollTable;
    protected DefaultTableModel defaultTableModel;

    protected JTextField[] textFieldsArray;
    protected JCheckBox[] checkBoxesArray;
    protected JButton button;
    protected JLabel footerLabel;

    public TableManager(boolean footerPanel, String buttonText, String commandButton, String[] columns, String[] fieldLabelArray) {
        this.setLayout(new BorderLayout());

        this.add(headerPanel(buttonText, commandButton, fieldLabelArray), BorderLayout.PAGE_START);
        this.add(centerPanel(columns), BorderLayout.CENTER);

        if (footerPanel) {
            this.add(this.footerPanel(), BorderLayout.PAGE_END);
        }
    }

    public TableManager(boolean footerPanel, String buttonText, String commandButton, String[] columns, String[] checkBoxLabelArray, String[] commandCheckBox) {
        this.setLayout(new BorderLayout());

        this.add(headerPanel(buttonText, commandButton, checkBoxLabelArray, commandCheckBox), BorderLayout.PAGE_START);
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

    private JPanel headerPanel(String buttonText, String commandButton, String[] checkBoxLabelArray, String[] commandCheckBox) {
        var panel = new JPanel(new FlowLayout());
        this.checkBoxesArray = new JCheckBox[checkBoxLabelArray.length];
        this.button = new JButton(buttonText);
        this.button.setActionCommand(commandButton);

        for (int i = 0; i < checkBoxLabelArray.length; i++) {
            this.checkBoxesArray[i] = new JCheckBox(checkBoxLabelArray[i]);
            this.checkBoxesArray[i].setActionCommand(commandCheckBox[i]);
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

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public DefaultTableModel getDefaultTableModel() {
        return defaultTableModel;
    }

    public void setDefaultTableModel(DefaultTableModel defaultTableModel) {
        this.defaultTableModel = defaultTableModel;
    }

    public JScrollPane getScrollTable() {
        return scrollTable;
    }

    public void setScrollTable(JScrollPane scrollTable) {
        this.scrollTable = scrollTable;
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public JLabel getFooterLabel() {
        return footerLabel;
    }

    public void setFooterLabel(JLabel footerLabel) {
        this.footerLabel = footerLabel;
    }

    public JTextField[] getTextFieldsArray() {
        return textFieldsArray;
    }

    public void setTextFieldsArray(JTextField[] textFieldsArray) {
        this.textFieldsArray = textFieldsArray;
    }

    public JCheckBox[] getCheckBoxesArray() {
        return checkBoxesArray;
    }

    public void setCheckBoxesArray(JCheckBox[] checkBoxesArray) {
        this.checkBoxesArray = checkBoxesArray;
    }
}
