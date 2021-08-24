package net.henrik.searchAlgorithmsTest;

import net.henrik.searchAlgorithms.PivotPartitioning;
import net.henrik.searchAlgorithms.SortingAlgorithm;
import net.henrik.utils.IntUtils;
import net.henrik.utils.StringUtils;

import java.util.Arrays;

public class PivotPartitioningTest {

    public static void main(String[] args) {
        //INIT
        if (args == null) {
            args = new String[]{"1", "10"};
        }
        int TEST_LENGTH = Integer.parseInt(args[1]);

        System.out.println("TESTING INTEGER");
        var arr = IntUtils.generateArray(TEST_LENGTH);
        if (args[0].equals("1"))
            System.out.println(Arrays.toString(arr));
        SortingAlgorithm<Integer> pivotPartitioning = new PivotPartitioning<>(Integer::compareTo);
        pivotPartitioning.sort(arr);
        if (args[0].equals("1"))
            System.out.println(Arrays.toString(arr));
        System.out.println(IntUtils.checkAscendingOrder(arr));

        System.out.println("\nTESTING STRING");
        var arrString = StringUtils.generateArrayString(TEST_LENGTH);
        if (args[0].equals("1"))
            System.out.println(Arrays.toString(arrString));
        SortingAlgorithm<String> pivotPartitioningString = new PivotPartitioning<>(String::compareTo);
        pivotPartitioningString.sort(arrString);
        if (args[0].equals("1"))
            System.out.println(Arrays.toString(arrString));
        System.out.println(StringUtils.checkAscendingOrder(arrString));
    }
}
