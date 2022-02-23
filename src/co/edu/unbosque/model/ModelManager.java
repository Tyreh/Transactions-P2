package co.edu.unbosque.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * The type Model manager.
 *
 * @author Oscar Moreno
 * @author Nelson Fandiño
 * @author Tomas Espitia
 * @author Nicolas Rodriguez
 */
public class ModelManager {

    private final ArrayList<Transaction> transactionsArray = new ArrayList<>();
    private final SimpleDateFormat WRONG_DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
    private final SimpleDateFormat CORRECT_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Instantiates a new Model manager.
     *
     * @param file the file
     */
    public ModelManager(File file) {
        uploadData(file);
    }

    /**
     * Upload data from a given csv file.
     *
     * @param file the file
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
     * Sum total sales of csv file.
     *
     * @return sum of all csv file sales.
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
     * Search all sales with the given invoice number.
     *
     * @param invoiceNo the invoice number to search
     * @return the array list with all coincidences
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
     * Search all sales with the given stock code.
     *
     * @param stockCode the stock code to search
     * @return the array list with all coincidences
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
     * Find partially by description array list.
     *
     * @param search    the word to search
     * @param order     sort search by quantity sold
     * @param initMonth the init month range
     * @param endMonth  the end month range
     * @return the array list with all coincidences
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
                search = search.toUpperCase();
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
     * Avg monthly sales object.
     *
     * @param groupByCountry the group by country
     * @return the object
     */
    public Object avgMonthlySales(boolean groupByCountry) {
        Calendar calendar = new GregorianCalendar();

        double[] monthValues = new double[12];
        int[] counter = new int[12];
        HashMap<String, double[]> countryValues = new HashMap<>();
        HashMap<String, int[]> countryValuesCounter = new HashMap<>();

        if (groupByCountry) {
            for (int i = 0; i < transactionsArray.size(); i++) {
                try {
                    Date transactionDate = CORRECT_DATE_FORMAT.parse(transactionsArray.get(i).getInvoiceDate());
                    calendar.setTime(transactionDate);
                    var month = calendar.get(Calendar.MONTH);
                    var currentSale = Double.parseDouble(transactionsArray.get(i).getQuantity()) * Double.parseDouble(transactionsArray.get(i).getUnitPrice());
                    var country = transactionsArray.get(i).getCountry();

                    //monthValues[month] += currentSale;
                    var countryMonths = countryValues.get(country);
                    var countryMonthsCounter = countryValuesCounter.get(country);

                    if (countryMonths == null) {
                        countryValues.put(country, new double[12]);
                        countryValuesCounter.put(country, new int[12]);
                        i--;
                    } else {
                        countryMonths[month] += currentSale;
                        countryMonthsCounter[month]++;
                        countryValues.put(country, countryMonths);
                        countryValuesCounter.put(country, countryMonthsCounter);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            for (var entry : countryValues.entrySet()) {
                var arrayDouble = entry.getValue();
                var test = countryValuesCounter.get(entry.getKey());
                for (int i = 0; i < arrayDouble.length; i++) {
                    arrayDouble[i] /= test[i];
                }
            }

            for (var entry : countryValues.entrySet()) {
                System.out.println(entry.getKey() + " ----> " + Arrays.toString(entry.getValue()));
            }
            return countryValues;
        } else {
            for (Transaction transaction : transactionsArray) {
                try {
                    Date transactionDate = CORRECT_DATE_FORMAT.parse(transaction.getInvoiceDate());
                    calendar.setTime(transactionDate);
                    var month = calendar.get(Calendar.MONTH);
                    var currentSale = Double.parseDouble(transaction.getQuantity()) * Double.parseDouble(transaction.getUnitPrice());

                    monthValues[month] += currentSale;
                    counter[month]++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            for (int i = 0; i < monthValues.length; i++) {
                monthValues[i] /= counter[i];
            }
            return monthValues;
        }
    }

    /**
     * Gets transactions array.
     *
     * @return the transactions array
     */
    public ArrayList<Transaction> getTransactionsArray() {
        return transactionsArray;
    }
}


