package net.henrik.searchAlgorithms;

import net.henrik.utils.StringUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BucketSortString implements SortingAlgorithm<String> {
    final List<Character> alphabet;
    final Comparator<String> comparator;

    public BucketSortString(List<Character> alphabet, Comparator<String> comparator) {
        this.alphabet = alphabet;
        this.comparator = comparator;
    }


    @Override
    public void sort(String[] arr) {
        List<List<String>> lst = new ArrayList<>();
        for (int i = 0; i < alphabet.size() + 1; i++) {
            lst.add(new ArrayList<>());
        }
        for (var string : arr) {
            if (string.length() == 0)
                lst.get(0).add(string);
            else
                lst.get(alphabet.indexOf(string.charAt(0)) + 1).add(string);
        }

        SortingAlgorithm<String> quickSort = new PivotPartitioning<>(String::compareTo);
        for (int i = 1; i < lst.size(); i++) {
            lst.get(i).sort(String::compareTo);
        }
        arr =  StringUtils.toStringArray(lst, arr.length);
    }
}