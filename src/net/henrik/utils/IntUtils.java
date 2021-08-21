package net.henrik.utils;

import java.util.Random;

public class IntUtils {

    public static Integer[] generateArray(int size) {
        Random random = new Random();
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt((int) Math.pow(10, 9));
        }
        return arr;
    }

    public static Integer[] generateArray(int size, int length) {
        Random random = new Random();
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt((int) Math.pow(10, length));
        }
        return arr;
    }

    public static Integer[] generateArray(int size, int length, Long seed) {
        Random random = new Random(seed);
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt((int) Math.pow(10, length));
        }
        return arr;
    }

    public static boolean checkAscendingOrder(Integer[] arr) {
        if (arr == null)
            throw new NullPointerException();
        if (arr.length == 1)
            return true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                System.out.println("FAILED: " + arr[i - 1] + "|" + arr[i] + " at "+ (i-1) + "|" + i);
                return false;
            }
        }
        return true;
    }
}
