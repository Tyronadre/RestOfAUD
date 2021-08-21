package net.henrik.searchAlgorithms;

import java.util.Comparator;

public class BubbleSort<T> implements SortingAlgorithm<T> {
    final Comparator<T> comparator;

    public BubbleSort(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public void sort(T[] arr) {
        for (int i = arr.length; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                if (comparator.compare(arr[j - 1], arr[j]) > 0) {
                    var temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
