package co.edu.unbosque.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ModelManager {

    private final ArrayList<Transaction> transactionsArray = new ArrayList<>();
    private final SimpleDateFormat WRONG_DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
    private final SimpleDateFormat CORRECT_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Constructor de la clase
     *
     * @param file
     */

    public ModelManager(File file) {
        uploadData(file);
    }

    /**
     * Sube el archivo csv y lo guarda en un array
     *
     * @param file archivo csv
     */

    public void uploadData(File file) {
        long startTime = System.currentTimeMillis();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            if (file.exists()) {
                String line = bufferedReader.readLine();
                line = bufferedReader.readLine();
                while (line != null) {
                    String[] separator;
                    if (line.contains("\"")) {
                        separator = new String[8];
                        StringBuilder temp = new StringBuilder();
                        boolean isQuote = false;
                        int counter = 0;
                        for (char c : line.toCharArray()) {
                            if (c == '"') {
                                isQuote = !isQuote;
                            }

                            if (c == ',' && !isQuote) {
                                separator[counter++] = temp.toString();
                                temp = new StringBuilder();
                            } else {
                                temp.append(c);
                            }
                        }
                        separator[counter] = temp.toString();
                    } else {
                        separator = line.split(",");
                    }

                    String invoiceNumber = separator[0];
                    String stockCode = separator[1];
                    String description = separator[2];
                    String quantity = separator[3];
                    String invoiceDate = separator[4];
                    String unitPrice = separator[5];
                    String customerId = separator[6];
                    String country = separator[7];

                    Date date = WRONG_DATE_FORMAT.parse(invoiceDate);
                    invoiceDate = CORRECT_DATE_FORMAT.format(date);

                    Transaction transactionToAdd = new Transaction(invoiceNumber, stockCode, description, quantity, invoiceDate, unitPrice, customerId, country);
                    transactionsArray.add(transactionToAdd);

                    line = bufferedReader.readLine();
                }
                bufferedReader.close();

                long endTime = System.currentTimeMillis();
                System.out.println("The file upload process finished in " + (endTime - startTime) + "ms.");
            } else {
                System.out.println("The specified file does not exist!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Calcula el total de las compras de la tienda
     *
     * @return el total de compras de la tienda
     */

    public double sumTotalSales() {
        var total = 0.0;
        for (Transaction transaction : transactionsArray) {
            var aux = Double.parseDouble(transaction.getQuantity()) * Double.parseDouble(transaction.getUnitPrice());
            total += aux;
        }
        return total;
    }

    /**
     * Devuelve la facturade compre de compra.
     *
     * @param invoiceNo el numero de la factura a buscar
     * @return la factura solicitada
     */

    public ArrayList<Transaction> findByInvoiceNo(String invoiceNo) {
        ArrayList<Transaction> foundInvoices = new ArrayList<>();

        for (Transaction transaction : transactionsArray) {
            var currentInvoice = transaction.getInvoiceNumber();
            if (invoiceNo.equalsIgnoreCase(currentInvoice)) {
                foundInvoices.add(transaction);
            }
        }
        return foundInvoices;
    }

    /**
     * Cuenta la cantidad de unidades vendidas para un stock pedido
     *
     * @param stockCode el stock code solicitado
     * @return el stock code encontrado
     */

    public ArrayList<Transaction> countByStockCode(String stockCode) {
        ArrayList<Transaction> foundStockCodes = new ArrayList<>();

        for (Transaction transaction : transactionsArray) {
            var currentStock = transaction.getStockCode();
            if (stockCode.equalsIgnoreCase(currentStock)) {
                foundStockCodes.add(transaction);
            }
        }
        return foundStockCodes;
    }

    /**
     * Retorna la lista de descripciones que coinciden parcialmente con el criterio de búsqueda incluyendo la cantidad de unidades vendidas con la opción de ordenar por el producto más vendido y filtrar por rango de meses
     *
     * @param search    string para encontgrar el texto
     * @param order     is es verdaddero, orden ale texto
     * @param initMonth el principio del mes
     * @param endMonth  el fin del mes
     * @return transacciones encontradas con esa descrpcion.
     */

    public ArrayList<Transaction> findPartiallyByDescription(String search, boolean order, int initMonth, int endMonth) {
        if ((endMonth < initMonth) || (endMonth > 12) || (initMonth < 1)) {
            return null;
        }

        ArrayList<Transaction> foundTransactions = new ArrayList<>();
        Calendar calendar = new GregorianCalendar();

        try {
            for (Transaction transaction : transactionsArray) {
                var currentDescription = transaction.getDescription();
                var invoiceDate = CORRECT_DATE_FORMAT.parse(transaction.getInvoiceDate());
                calendar.setTime(invoiceDate);
                var month = calendar.get(Calendar.MONTH);
                if (currentDescription.contains(search)) {
                    if (month >= (initMonth - 1) && month <= (endMonth - 1)) {
                        foundTransactions.add(transaction);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (order) {
            QuickSort.quicksort(foundTransactions, 0, (foundTransactions.size() - 1));
        }

        return foundTransactions;
    }

    /**
     * Retorna el promedio de ventas mensuales con la opción de agrupar por país
     *
     * @param groupByCountry si es verdaddero, organiza todos los promedios por paises.
     * @return el promedio de todos los paises
     */

    public ArrayList<double[]> avgMonthlySales(boolean groupByCountry) {
        int currentYear = 2010;
        ArrayList<double[]> values = new ArrayList<>();
        Calendar calendar = new GregorianCalendar();

        double[] actualValues = new double[12];
        for (int i = 0; i < transactionsArray.size(); i++) {
            try {
                Date transactionDate = CORRECT_DATE_FORMAT.parse(transactionsArray.get(i).getInvoiceDate());
                calendar.setTime(transactionDate);
                var month = calendar.get(Calendar.MONTH);
                var year = calendar.get(Calendar.YEAR);
                var currentSale = Double.parseDouble(transactionsArray.get(i).getQuantity()) * Double.parseDouble(transactionsArray.get(i).getUnitPrice());

                if (currentYear == year) {
                    actualValues[month] += currentSale;
                } else {
                    i--;
                    currentYear = year;
                    values.add(actualValues);
                    actualValues = new double[12];
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        values.add(actualValues);
        return values;
    }

    /**
     * Transaction get method
     *
     * @return transaction object.
     */
    public ArrayList<Transaction> getTransactionsArray() {
        return transactionsArray;
    }
}


