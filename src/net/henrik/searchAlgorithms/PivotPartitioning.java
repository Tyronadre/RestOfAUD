package net.henrik.searchAlgorithms;

import java.util.Comparator;
import java.util.List;

public class PivotPartitioning<T> implements SortingAlgorithm<T> {

    private final Comparator<T> comparator;


    public PivotPartitioning(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void sort(T[] arr) {
        partitionHelper(arr, 0, arr.length - 1);
    }

    private T getPivot(T[] arr, int from, int too) {
        if (from == too || arr == null || arr.length < from)
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
