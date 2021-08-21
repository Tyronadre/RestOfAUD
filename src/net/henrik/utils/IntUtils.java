package net.henrik.utils;

import java.util.Random;

public class IntUtils {

    public static Integer[] generateArray(int size, int length) {
        Random random = new Random();
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt((int) Math.pow(10,length));
        }
        return arr;
    }
}
