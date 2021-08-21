package net.henrik.searchAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
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
        List<String>[] buckets = new List[alphabet.size()+1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        int counter = 0;
        boolean finished = false;
        while (!finished) {
            for (var string : arr) {
                if(string.length()>counter){
                    buckets[alphabet.indexOf(string.charAt(string.length()-counter-1)) + 1].add(string);
                } else
                    buckets[0].add(string);
            }
            if (buckets[0].size() == arr.length)
                finished = true;

            int insertionCounter = 0;
            for (var bucket : buckets
                 ) {
                if (!bucket.isEmpty()){
                    for (var item:bucket
                         ) {
                        arr[insertionCounter++] = item;

                    }
                bucket.removeIf(s -> true);}
            }

            counter++;
        }
    }
}