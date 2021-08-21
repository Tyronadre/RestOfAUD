package net.henrik.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class StringUtils {

    public static String[] generateArrayString(int size) {
        String[] arr = new String[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.ints(97, 123).limit(random.nextInt(11)).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        }
        return arr;
    }

    public static String[] generateArrayString(int size, int length) {
        String[] arr = new String[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.ints(97, 123).limit(random.nextInt(length + 1)).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        }
        return arr;
    }

    public static String[] generateArrayString(int size, int length, long seed) {
        String[] arr = new String[size];
        Random random = new Random(seed);
        for (int i = 0; i < size; i++) {
            arr[i] = random.ints(97, 123).limit(random.nextInt(length + 1)).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        }
        return arr;
    }

    public static boolean checkAscendingOrder(String[] arr) {
        if (arr == null)
            throw new NullPointerException();
        if (arr.length == 1)
            return true;
        Comparator<String> comparator = Comparator.naturalOrder();
        for (int i = 1; i < arr.length; i++) {
            if (comparator.compare(arr[i - 1], arr[i]) > 0) {
                System.out.println("FAILED: " + arr[i - 1] + "|" + arr[i] + " at " + (i - 1) + "|" + i);
                return false;
            }
        }
        return true;
    }

    public static List<Character> getStandardAlphabet() {
        List<Character> alphabet = new ArrayList<>();
        for (int i = 97; i < 123; i++) {
            alphabet.add((char) (i));
        }
        return alphabet;
    }
}
