package co.edu.unbosque.model;

import java.util.List;

public class QuickSort {

    public QuickSort() {

    }

    /**
     * QuickSort Algorithm taken but adapted from: http://puntocomnoesunlenguaje.blogspot.com/2012/12/java-quicksort.html
     *
     * @param transactions
     * @param left
     * @param right
     */
    public static void quicksort(List<Transaction> transactions, int left, int right) {
        Transaction pivot = transactions.get(left);
        int i = left;
        int j = right;
        Transaction aux;
        while (i < j) {
            while (Integer.parseInt(transactions.get(i).getQuantity()) >= Integer.parseInt(pivot.getQuantity()) && i < j) {
                i++;
            }

            while (Integer.parseInt(transactions.get(j).getQuantity()) < Integer.parseInt(pivot.getQuantity())) {
                j--;
            }

            if (i < j) {
                aux = transactions.get(i);
                transactions.set(i, transactions.get(j));
                transactions.set(j, aux);
            }
        }

        transactions.set(left, transactions.get(j));
        transactions.set(j, pivot);

        if (left < j - 1) {
            quicksort(transactions, left, j - 1);
        }

        if (j + 1 < right) {
            quicksort(transactions, j + 1, right);
        }
    }
}
