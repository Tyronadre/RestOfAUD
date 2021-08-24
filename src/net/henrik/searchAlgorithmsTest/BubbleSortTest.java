package net.henrik.searchAlgorithmsTest;

import net.henrik.searchAlgorithms.BubbleSort;
import net.henrik.utils.IntUtils;
import net.henrik.utils.StringUtils;

import java.util.Arrays;


public class BubbleSortTest {
    private static final int TEST_LENGTH = 10000;

    public static void main(String[] args) {
        //INIT
        if (args == null) {
            args = new String[]{"1", "10"};
        }
        int TEST_LENGTH = Integer.parseInt(args[1]);

        System.out.println("TESTING INTEGER");
        var intArr = IntUtils.generateArray(TEST_LENGTH);
        if (args[0].equals("1"))
            System.out.println(Arrays.toString(intArr));
        var intBubbleSort = new BubbleSort<>(Integer::compareTo);
        intBubbleSort.sort(intArr);
        if (args[0].equals("1"))
            System.out.println(Arrays.toString(intArr));
        System.out.println(IntUtils.checkAscendingOrder(intArr));


        System.out.println("\nTESTING STRING");
        var stringArr = StringUtils.generateArrayString(TEST_LENGTH, 10);
        if (args[0].equals("1"))
            System.out.println(Arrays.toString(stringArr));
        var sortingAlgorithm2 = new BubbleSort<>(String::compareTo);
        sortingAlgorithm2.sort(stringArr);
        if (args[0].equals("1"))
            System.out.println(Arrays.toString(stringArr));
        System.out.println(StringUtils.checkAscendingOrder(stringArr));
    }
}
