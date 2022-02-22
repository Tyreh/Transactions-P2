package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TableManager extends JPanel {

    private final String[] columns;
    protected JTable table;
    protected JScrollPane scrollTable;
    protected DefaultTableModel defaultTableModel;
    protected JTextField textField;
    protected JButton button;
    protected JLabel label;
    protected JLabel footerLabel;
    protected JComboBox<String> comboBox;

    public TableManager(boolean footerPanel, boolean comboBox, String[] columns) {
        this.columns = columns;
        this.setLayout(new BorderLayout());
        this.init(comboBox);

        if (footerPanel) {
            this.add(this.footerPanel(), BorderLayout.PAGE_END);
        }
    }

    private void init(boolean comboBox) {
        this.add(this.headerPanel(comboBox), BorderLayout.PAGE_START);
        this.add(this.centerPanel(), BorderLayout.CENTER);
    }

    private JPanel headerPanel(boolean comboBox) {
        var panel = new JPanel(new FlowLayout());
        this.label = new JLabel();
        this.textField = new JTextField(20);
        this.button = new JButton();
        panel.add(label);
        panel.add(textField);
        if (comboBox) {
            this.comboBox = new JComboBox<>();
            panel.add(this.comboBox);
        }
        panel.add(button);
        return panel;
    }

    private JPanel centerPanel() {
        var panel = new JPanel(new GridLayout());
        this.defaultTableModel = new DefaultTableModel(this.columns, 0);
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

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
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
}
