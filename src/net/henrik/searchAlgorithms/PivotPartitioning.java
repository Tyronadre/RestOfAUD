package net.henrik.searchAlgorithms;

import java.util.Comparator;

public class PivotPartitioning implements SortingAlgorithm<Integer> {

    private final Comparator<Integer> comparator;


    public PivotPartitioning(Comparator<Integer> comparator) {
        this.comparator = comparator;
    }

    public void sort(Integer[] arr) {
        Integer pivot = getPivot(arr, 0, arr.length);
        int i = 0;
        int j = 0;
        for (int k = 0; k < arr.length; k++) {
            if ((comparator.compare(arr[k], pivot) == 0)) {
                var temp = arr[k];
                arr[k] = arr[j];
                arr[j] = temp;
                j++;
            } else if (comparator.compare(arr[k], pivot) < 0) {
                // Mit erstem element der > pivot liste tauschen
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
        if (j - 1 < arr.length )
            partitionHelper(arr, j + 1, arr.length);
    }

    private Integer getPivot(Integer[] arr, int from, int too) {
        if (from + 1 == too)
            throw new IllegalArgumentException();
        double median = (double) arr[from];
        for (int i = from + 1; i < too; i++) {
            median = (median + (Integer) arr[i] )/ 2;
        }
        return (int) median;
    }

    private void partitionHelper(Integer[] arr, int from, int too) {
        if (from == too || from + 1 == too)
            return;
        Integer pivot = arr[from];
        int i = from;
        int j = from;
        for (int k = from; k < too; k++) {
            if ((comparator.compare(arr[k], pivot) == 0)) {
                var temp = arr[k];
                arr[k] = arr[j];
                arr[j] = temp;
                j++;
            } else if (comparator.compare(arr[k], pivot) < 0) {
                // Mit erstem element der > pivot liste tauschen
                var temp = arr[k];
                arr[k] = arr[j];
                arr[j] = arr[i];

                arr[i] = temp;
                i++;
                j++;
            }
        }
        if (j != 0) {
            partitionHelper(arr, 0, i);
        }
        partitionHelper(arr, j, too);
    }
}
