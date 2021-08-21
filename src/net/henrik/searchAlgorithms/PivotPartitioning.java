package net.henrik.searchAlgorithms;

import java.util.Comparator;

public class PivotPartitioning<T> implements SortingAlgorithm<T> {

    private final Comparator<T> comparator;


    public PivotPartitioning(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void sort(T[] arr) {
        partitionHelper(arr, 0, arr.length - 1);
        /*T pivot = getPivot(arr, 0, arr.length);
        int i = 0;
        int j = 0;
        for (int k = 0; k < arr.length; k++) {
            if ((comparator.compare(arr[k], pivot) == 0)) {
                var temp = arr[k];
                arr[k] = arr[j];
                arr[j] = temp;
                j++;
            } else if (comparator.compare(arr[k], pivot) < 0) {
                var temp = arr[k];
                arr[k] = arr[j];
                arr[j] = arr[i];

                arr[i] = temp;
                i++;
                j++;
            }
        }
        if (i > 1)
            partitionHelper(arr, 0, i - 1);
        if (j - 1 < arr.length)
            partitionHelper(arr, j, arr.length - 1);

         */
    }

    private T getPivot(T[] arr, int from, int too) {
        if (from == too)
            throw new IllegalArgumentException();
        return arr[from];
    }

    private void partitionHelper(T[] arr, int from, int too) {
        if (from == too)
            return;
        T pivot = getPivot(arr, from, too);
        int i = from;
        int j = from;
        for (int k = from; k <= too; k++) {
            if ((comparator.compare(arr[k], pivot) == 0)) {
                var temp = arr[k];
                arr[k] = arr[j];
                arr[j] = temp;
                j++;
            } else if (comparator.compare(arr[k], pivot) < 0) {
                var temp = arr[k];
                arr[k] = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
                j++;
            }
        }
        if (i - from > 1)
            partitionHelper(arr, from, i - 1);
        if (too - j > 0)
            partitionHelper(arr, j, too);
    }
}
