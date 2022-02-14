package co.edu.unbosque.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ModelManager {

    private final ArrayList<Transaction> transactionsArray;

    public ModelManager(File file) {
        transactionsArray = new ArrayList<>();
        uploadData(file);
    }

    public void uploadData(File file) {
        ArrayList<String> csvContent = new ArrayList<>();
        BufferedReader bufferedReader;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            if (file.exists()) {
                String line = bufferedReader.readLine();
                while (line != null) {
                    csvContent.add(line);
                    line = bufferedReader.readLine();
                }
                bufferedReader.close();

                csvContent.remove(0);
                for (String csvLine : csvContent) {
                    String[] separator;
                    String invoiceNumber;
                    String stockCode;
                    String description;
                    String quantity;
                    String invoiceDate;
                    String unitPrice;
                    String customerId;
                    String country;

                    if (csvLine.contains("\"")) {
                        separator = new String[8];
                        StringBuilder temp = new StringBuilder();
                        boolean isQuote = false;
                        int counter = 0;
                        for (char c : csvLine.toCharArray()) {
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
                        separator = csvLine.split(",");
                    }

                    invoiceNumber = separator[0];
                    stockCode = separator[1];
                    description = separator[2];
                    quantity = separator[3];
                    invoiceDate = separator[4];
                    unitPrice = separator[5];
                    customerId = separator[6];
                    country = separator[7];

                    Transaction transactionToAdd = new Transaction(invoiceNumber, stockCode, description, quantity, invoiceDate, unitPrice, customerId, country);
                    transactionsArray.add(transactionToAdd);
                }
                System.out.println("The file upload process is finished!");
            } else {
                System.out.println("The specified file does not exist!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double sumTotalSales() {
        var total = 0.0;
        for (Transaction transaction : transactionsArray) {
            var aux = Double.parseDouble(transaction.getQuantity()) * Double.parseDouble(transaction.getUnitPrice());
            total += aux;
        }
        return total;
    }

    public ArrayList<Transaction> findByInvoiceNo(String invoiceNo) {
        ArrayList<Transaction> array = new ArrayList<>();

        for (Transaction transaction : transactionsArray) {
            var currentInvoice = transaction.getInvoiceNumber();
            if (invoiceNo.equalsIgnoreCase(currentInvoice)) {
                array.add(transaction);
            }
        }
        return array;
    }

    public ArrayList<Transaction> countByStockCode(String stockCode) {
        ArrayList<Transaction> array = new ArrayList<>();

        for (Transaction transaction : transactionsArray) {
            var currentStock = transaction.getStockCode();
            if (stockCode.equalsIgnoreCase(currentStock)) {
                array.add(transaction);
            }
        }
        return array;
    }

/*
    public ArrayList<Transaction> findPartiallyByDescription(String search, boolean order, int initMonth, int endMonth) {
        ArrayList<Transaction> array = new ArrayList<>();

        for (Transaction transaction : transactionsArray) {
            var currentDescription = transaction.getDescription();
            if (search.equalsIgnoreCase(currentDescription)) {
                array.add(transaction);
            }

        }
        return array;
    }
*/



   /* public String avgMonthlySales(boolean groupByCountry) {
        String text;

        try {
            String startDate = "01-01-2010";
            SimpleDateFormat simpleDataFormat = new SimpleDateFormat("dd-MM-yyyy");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(simpleDataFormat.parse(startDate));
            calendar.add(Calendar.DATE, 1);  // number of days to add
            startDate = simpleDataFormat.format(calendar.getTime());  // dt is now the new date

            for (Transaction transactions : transactionsArray) {
                var separator = transactions.getInvoiceDate().split("/");
                var month = Integer.parseInt(separator[1]);



            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(Transaction transaction : transactionsArray) {
            String[] separator = transaction.getInvoiceDate().split("/");

            var currentStock = transaction.getStockCode();
        }
        if (groupByCountry) {

        } else {

        }*/
}
