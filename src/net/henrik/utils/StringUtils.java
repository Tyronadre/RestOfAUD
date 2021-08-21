package net.henrik.utils;

import java.util.Random;

public class StringUtils {

    public static String[] generateArrayString(int size,int length) {
        String[] arr = new String[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random
                    .ints(97, 123)
                    .limit(random.nextInt((int) Math.pow(10,length)))
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
        }
        return arr;

    }
}
