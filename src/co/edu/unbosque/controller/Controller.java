package co.edu.unbosque.controller;

import co.edu.unbosque.model.ModelManager;
import co.edu.unbosque.model.Transaction;
import co.edu.unbosque.view.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase encargada de ejecutar las diversas funciones del programa.
 * @author Oscar Moreno
 * @author Nelson Fandiño
 * @author Tomas Espitia
 * @author Nicolas Rodriguez
 */
public class Controller implements ActionListener {

    /**
     * Permite acceder a la clase, sus metodos y objetos.
     * La clase permite cargar el archivo csv y realizar busquedas. Se inicializa especificando la ruta del archivo.
     */
    private final ModelManager modelManager = new ModelManager(new File("data/data.csv"));

    /**
     * Permite acceder a la interfaz grafica del proyecto y sus paneles.
     */
    private final MainFrame mainFrame = new MainFrame();
    private final DecimalFormat FORMATTER = new DecimalFormat("#,###.00");
    private int checkBoxState;

    public Controller() {
        registerActionListeners();
        registerItemListeners();
    }

    public void registerActionListeners() {
        var mainPanelButtons = mainFrame.getMainPanel().getButtons();
        for (var button : mainPanelButtons) {
            button.addActionListener(this);
        }

        mainFrame.getInvoicePanel().getButton().addActionListener(this);
        mainFrame.getSoldStockPanel().getButton().addActionListener(this);
        mainFrame.getDescriptionPanel().getButton().addActionListener(this);
        mainFrame.getAveragePanel().getButton().addActionListener(this);
    }

    public void registerItemListeners() {
        var averageCheckBoxes = mainFrame.getAveragePanel().getCheckBoxesArray();

        for (var checkBox : averageCheckBoxes) {
            checkBox.addItemListener(this::itemStateChanged);
        }
    }

    public void itemStateChanged(ItemEvent e) {
        checkBoxState = e.getStateChange();
        System.out.println(checkBoxState);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        System.out.println(command);

        switch (command) {
            case "SUM_TOTAL_SALES":
                Messages.showInfo("Total sales is: \n\n$" + FORMATTER.format(modelManager.sumTotalSales()));
                break;
            case "FIND_BY_INVOICE_NUMBER":
            case "COUNT_BY_STOCK_CODE":
            case "AVERAGE_MONTHLY_SALES":
            case "FIND_PARTIALLY_BY_DESCRIPTION":
                panelVisibility(command);
                break;
            case "INVOICE_SEARCH":
                InvoicePanel invoicePanel = mainFrame.getInvoicePanel();
                var invoiceSearch = invoicePanel.getTextFieldsArray()[0].getText();
                var invoiceTableModel = invoicePanel.getDefaultTableModel();
                var invoiceNotFound = "No invoice found with ID \"" + invoiceSearch + "\".";
                var invoiceFoundTransactions = modelManager.findByInvoiceNo(invoiceSearch);
                this.addTransactionsToTable(invoiceTableModel, invoiceFoundTransactions, invoiceNotFound);
                break;
            case "STOCK_SOLD_SEARCH":
                SoldStockPanel soldStockPanel = mainFrame.getSoldStockPanel();
                var soldStockSearch = soldStockPanel.getTextFieldsArray()[0].getText();
                var soldStockTableModel = soldStockPanel.getDefaultTableModel();
                var soldStockNotFound = "No stock found with code \"" + soldStockSearch + "\".";
                var soldStockFoundTransactions = modelManager.countByStockCode(soldStockSearch);
                var soldStockFooterLabel = soldStockPanel.getFooterLabel();
                this.addTransactionsToTable(soldStockTableModel, soldStockFoundTransactions, soldStockFooterLabel, soldStockNotFound);
                break;
            case "DESCRIPTION_SEARCH":
                try {
                    DescriptionPanel descriptionPanel = mainFrame.getDescriptionPanel();
                    var descriptionSearch = descriptionPanel.getTextFieldsArray()[0].getText();
                    var descriptionInitMonth = Integer.parseInt(descriptionPanel.getTextFieldsArray()[1].getText());
                    var descriptionEndMonth = Integer.parseInt(descriptionPanel.getTextFieldsArray()[2].getText());
                    var descriptionTableModel = descriptionPanel.getDefaultTableModel();
                    var descriptionNotFound = "No description contains \"" + descriptionSearch + "\".";
                    var descriptionFoundTransactions = modelManager.findPartiallyByDescription(descriptionSearch, true, descriptionInitMonth, descriptionEndMonth);
                    this.addTransactionsToTable(descriptionTableModel, descriptionFoundTransactions, descriptionNotFound);
                } catch (NumberFormatException ex) {
                    Messages.showError("Init month and end month fields must be numbers.");
                }
                break;
            case "AVERAGE_SEARCH":
                AveragePanel averagePanel = mainFrame.getAveragePanel();
                if (checkBoxState == 1) {
                } else if (checkBoxState == 2) {

                }
        }
    }

    public void addTransactionsToTable(DefaultTableModel tableModel, ArrayList<Transaction> foundTransactions, String notFoundMessage) {
        tableModel.setRowCount(0);
        if (foundTransactions.size() > 0) {
            for (Transaction transaction : foundTransactions) {
                tableModel.addRow(new String[]{transaction.getInvoiceNumber(), transaction.getStockCode(), transaction.getDescription(), transaction.getQuantity(), transaction.getInvoiceDate(), transaction.getUnitPrice(), transaction.getCustomerId(), transaction.getCountry()});
            }
        } else {
            Messages.showError(notFoundMessage);
        }
    }

    public void addTransactionsToTable(DefaultTableModel tableModel, ArrayList<Transaction> foundTransactions, JLabel footerLabel, String notFoundMessage) {
        tableModel.setRowCount(0);
        if (foundTransactions.size() > 0) {
            var counter = 0;
            for (Transaction transaction : foundTransactions) {
                tableModel.addRow(new String[]{transaction.getInvoiceNumber(), transaction.getStockCode(), transaction.getDescription(), transaction.getQuantity(), transaction.getInvoiceDate(), transaction.getUnitPrice(), transaction.getCustomerId(), transaction.getCountry()});
                counter++;
            }
            footerLabel.setText(counter + " units of ");
        } else {
            Messages.showError(notFoundMessage);
        }
    }

    public void panelVisibility(String command) {
        HashMap<String, JPanel> panels = new HashMap<>();
        InvoicePanel invoicePanel = mainFrame.getInvoicePanel();
        SoldStockPanel soldStockPanel = mainFrame.getSoldStockPanel();
        DescriptionPanel descriptionPanel = mainFrame.getDescriptionPanel();
        AveragePanel averagePanel = mainFrame.getAveragePanel();

        panels.put("FIND_BY_INVOICE_NUMBER", invoicePanel);
        panels.put("COUNT_BY_STOCK_CODE", soldStockPanel);
        panels.put("FIND_PARTIALLY_BY_DESCRIPTION", descriptionPanel);
        panels.put("AVERAGE_MONTHLY_SALES", averagePanel);

        for (var entry : panels.entrySet()) {
            entry.getValue().setVisible(false);
            mainFrame.remove(entry.getValue());
        }
        mainFrame.add(panels.get(command)).setVisible(true);
    }
}
