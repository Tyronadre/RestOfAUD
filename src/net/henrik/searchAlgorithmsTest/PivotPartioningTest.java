package net.henrik.searchAlgorithmsTest;

import net.henrik.searchAlgorithms.PivotPartitioning;
import net.henrik.searchAlgorithms.SortingAlgorithm;
import net.henrik.utils.IntUtils;

import java.util.Arrays;

public class PivotPartioningTest {

    public static void main(String[] args) {
        var arr = IntUtils.generateArray(10000000,5);
        System.out.println(Arrays.toString(arr));

        SortingAlgorithm<Integer> pivotPartitioning = new PivotPartitioning(Integer::compareTo);
        pivotPartitioning.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
