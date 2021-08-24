package net.henrik.searchAlgorithmsTest;

import net.henrik.searchAlgorithms.BucketSortString;
import net.henrik.utils.StringUtils;

import java.util.Arrays;

public class BucketSortTest {

    public static void main(String[] args) {
        //INIT
        if (args.length == 0) {
            args = new String[]{"1","100"};
        }
        int TEST_LENGTH = Integer.parseInt(args[1]);

        System.out.println("TESTING INTEGER");

        System.out.println("not implemented");

        System.out.println("\nTESTING STRING");
        var alphabet = StringUtils.getStandardAlphabet();
        var stringBucketSort = new BucketSortString(alphabet, String::compareTo);
        var stringArr = StringUtils.generateArrayString(TEST_LENGTH,10, 0L);
        if (args[0].equals("1"))
            System.out.println(Arrays.toString(stringArr));
        stringBucketSort.sort(stringArr);
        if (args[0].equals("1"))
            System.out.println(Arrays.toString(stringArr));
        System.out.println(StringUtils.checkAscendingOrder(stringArr));

    }
}
