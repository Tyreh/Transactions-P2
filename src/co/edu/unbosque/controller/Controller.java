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
import java.util.Arrays;
import java.util.HashMap;

/**
 * Clase encargada de ejecutar las diversas funciones del programa.
 *
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
        var descriptionCheckBoxes = mainFrame.getDescriptionPanel().getCheckBoxesArray();

        for (var checkBox : averageCheckBoxes) {
            checkBox.addItemListener(this::itemStateChanged);
        }

        for (var checkBox : descriptionCheckBoxes) {
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
                    var descriptionInitMonth = descriptionPanel.getTextFieldsArray()[1].getText().equals("") ? 1 : Integer.parseInt(descriptionPanel.getTextFieldsArray()[1].getText());
                    var descriptionEndMonth = descriptionPanel.getTextFieldsArray()[2].getText().equals("") ? 12 : Integer.parseInt(descriptionPanel.getTextFieldsArray()[2].getText());
                    var descriptionTableModel = descriptionPanel.getDefaultTableModel();
                    var descriptionNotFound = "No description contains \"" + descriptionSearch + "\".";

                    if (descriptionSearch.equals("")) {
                        Messages.showError("You must put a word in the search field.");
                    } else {
                        var descriptionFoundTransactions = modelManager.findPartiallyByDescription(descriptionSearch, (checkBoxState == 1), descriptionInitMonth, descriptionEndMonth);
                        this.addTransactionsToTable(descriptionTableModel, descriptionFoundTransactions, descriptionNotFound);
                    }
                } catch (NumberFormatException ex) {
                    Messages.showError("Init month and end month fields must be numbers.");
                } catch (NullPointerException ex2) {
                    Messages.showError("The init month and end month must be in a range from 1 to 12 respectively.");
                }
                break;
            case "AVERAGE_SEARCH":
                AveragePanel averagePanel = mainFrame.getAveragePanel();
                var averageTableModel = averagePanel.getDefaultTableModel();
                var averagesFound = modelManager.avgMonthlySales((checkBoxState == 1));
                if (checkBoxState == 1) {
                    addTransactionsToTable(averageTableModel, (HashMap<String, double[]>) averagesFound, "");
                } else {
                    addTransactionsToTable(averageTableModel, (double[]) averagesFound, "");

                }
        }
    }

    public void addTransactionsToTable(DefaultTableModel tableModel, ArrayList<Transaction> foundTransactions, String notFoundMessage) {
        tableModel.setRowCount(0);
        if (foundTransactions.size() > 0) {
            for (Transaction transaction : foundTransactions) {
                var invoiceNumber = transaction.getInvoiceNumber();
                var stockCode = transaction.getStockCode();
                var description = transaction.getDescription();
                var quantity = transaction.getQuantity();
                var invoiceDate = transaction.getInvoiceDate();
                var unitPrice = transaction.getUnitPrice();
                var customerId = transaction.getCustomerId();
                var country = transaction.getCountry();
                tableModel.addRow(new String[]{invoiceNumber, stockCode, description, quantity, invoiceDate, unitPrice, customerId, country});
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
                var invoiceNumber = transaction.getInvoiceNumber();
                var stockCode = transaction.getStockCode();
                var description = transaction.getDescription();
                var quantity = transaction.getQuantity();
                var invoiceDate = transaction.getInvoiceDate();
                var unitPrice = transaction.getUnitPrice();
                var customerId = transaction.getCustomerId();
                var country = transaction.getCountry();
                tableModel.addRow(new String[]{invoiceNumber, stockCode, description, quantity, invoiceDate, unitPrice, customerId, country});
                counter++;
            }
            footerLabel.setText(counter + " units of ");
        } else {
            Messages.showError(notFoundMessage);
        }
    }

    public void addTransactionsToTable(DefaultTableModel tableModel, double[] averages, String notFoundMessage) {
        tableModel.setRowCount(0);
        if (averages.length > 0) {
            var january = averages[0] == 0.0 ? "0,0" : FORMATTER.format(averages[0]);
            var february = averages[1] == 0.0 ? "0,0" : FORMATTER.format(averages[1]);
            var march = averages[2] == 0.0 ? "0,0" : FORMATTER.format(averages[2]);
            var april = averages[3] == 0.0 ? "0,0" : FORMATTER.format(averages[3]);
            var may = averages[4] == 0.0 ? "0,0" : FORMATTER.format(averages[4]);
            var june = averages[5] == 0.0 ? "0,0" : FORMATTER.format(averages[5]);
            var july = averages[6] == 0.0 ? "0,0" : FORMATTER.format(averages[6]);
            var august = averages[7] == 0.0 ? "0,0" : FORMATTER.format(averages[7]);
            var september = averages[8] == 0.0 ? "0,0" : FORMATTER.format(averages[8]);
            var october = averages[9] == 0.0 ? "0,0" : FORMATTER.format(averages[9]);
            var november = averages[10] == 0.0 ? "0,0" : FORMATTER.format(averages[10]);
            var december = averages[11] == 0.0 ? "0,0" : FORMATTER.format(averages[11]);
            tableModel.addRow(new String[]{"", january, february, march, april, may, june, july, august, september, october, november, december});
        } else {
            Messages.showError(notFoundMessage);
        }
    }

    public void addTransactionsToTable(DefaultTableModel tableModel, HashMap<String,double[]> averages, String notFoundMessage) {
        tableModel.setRowCount(0);
        if (averages.size() > 0) {
            for (var entry : averages.entrySet()) {
                var country = entry.getKey();
                var arrayValues = Arrays.stream(entry.getValue()).toArray();
                var january = arrayValues[0] == 0.0 ? "0,0" : FORMATTER.format(arrayValues[0]);
                var february = arrayValues[1] == 0.0 ? "0,0" : FORMATTER.format(arrayValues[1]);
                var march = arrayValues[2] == 0.0 ? "0,0" : FORMATTER.format(arrayValues[2]);
                var april = arrayValues[3] == 0.0 ? "0,0" : FORMATTER.format(arrayValues[3]);
                var may = arrayValues[4] == 0.0 ? "0,0" : FORMATTER.format(arrayValues[4]);
                var june = arrayValues[5] == 0.0 ? "0,0" : FORMATTER.format(arrayValues[5]);
                var july = arrayValues[6] == 0.0 ? "0,0" : FORMATTER.format(arrayValues[6]);
                var august = arrayValues[7] == 0.0 ? "0,0" : FORMATTER.format(arrayValues[7]);
                var september = arrayValues[8] == 0.0 ? "0,0" : FORMATTER.format(arrayValues[8]);
                var october = arrayValues[9] == 0.0 ? "0,0" : FORMATTER.format(arrayValues[9]);
                var november = arrayValues[10] == 0.0 ? "0,0" : FORMATTER.format(arrayValues[10]);
                var december = arrayValues[11] == 0.0 ? "0,0" : FORMATTER.format(arrayValues[11]);
                tableModel.addRow(new String[]{country, january, february, march, april, may, june, july, august, september, october, november, december});
            }
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
