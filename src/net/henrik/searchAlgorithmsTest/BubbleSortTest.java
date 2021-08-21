package net.henrik.searchAlgorithmsTest;

import net.henrik.searchAlgorithms.BubbleSort;
import net.henrik.searchAlgorithms.SortingAlgorithm;
import net.henrik.utils.StringUtils;

import java.util.Arrays;
import java.util.Random;


public class BubbleSortTest {
    private static long SEED;

    public static void main(String[] args) {
        /*SortingAlgorithm<Integer> sortingAlgorithm = new BubbleSort<>(Integer::compareTo);
        var arr = generateArray(1000);
        System.out.println(Arrays.toString(arr));
        sortingAlgorithm.sort(arr);
        System.out.println(Arrays.toString(arr));
        */

        var arr2 = StringUtils.generateArrayString(1000000,20);
        System.out.println(Arrays.toString(arr2));
        var sortingAlgorithm2 = new BubbleSort<>(String::compareTo);
        sortingAlgorithm2.sort(arr2);
        System.out.println(Arrays.toString(arr2));
    }


    private static Integer[] generateArray(int size) {
        Random random = new Random();
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }

    private static String[] generateArrayString(int size) {
        String[] arr = new String[size];
        Random random = new Random();
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        for (int i = 0; i < size; i++) {
            arr[i] = random
                    .ints(leftLimit, rightLimit + 1)
                    .limit(random.nextInt(10))
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
        }
        return arr;

    }

}
