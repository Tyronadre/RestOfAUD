package net.henrik.searchAlgorithmsTest;

import net.henrik.searchAlgorithms.BucketSortString;
import net.henrik.utils.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class BucketSortTest {
    public static void main(String[] args) {
        var alphabet = new ArrayList<Character>();
        for (int i = 97; i < 123; i++) {
            alphabet.add((char) (i));
        }

        var stringBucketSort = new BucketSortString(alphabet,String::compareTo);
        var stringArr = StringUtils.generateArrayString(10000000,10);
        System.out.println(Arrays.toString(stringArr));
        stringBucketSort.sort(stringArr);
        System.out.println(Arrays.toString(stringArr));

    }
}
