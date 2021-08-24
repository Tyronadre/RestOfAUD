package net.henrik.searchAlgorithmsTest;

public class runAllTests {
    private static final boolean PRINT_ARRAYS_TO_CONSOLE = false;
    private static final int TEST_LENGTH = 10000;

    public static void main(String[] args) {

        //INIT
        var arguments = new String[2];
        if (PRINT_ARRAYS_TO_CONSOLE)
            arguments[0] = "1";
        else
            arguments[0] = "0";
        arguments[1] = String.valueOf(TEST_LENGTH);


        System.out.println("BubbleSort:");
        BubbleSortTest.main(arguments);
        System.out.println("\nBucketSort");
        BucketSortTest.main(arguments);
        System.out.println("\nQuicksort");
        PivotPartitioningTest.main(arguments);
    }
}
