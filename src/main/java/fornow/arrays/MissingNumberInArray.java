package fornow.arrays;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class MissingNumberInArray {

    private static int NUM_TOTAL_RANGE = 1000;
    private static int NUM_MISSING_RANGE = 1000;
    private static int COUNT_MISSING = 10;

    public static void main(String[] args) {
        Random rand = new Random();
        int randomNum = rand.nextInt(NUM_MISSING_RANGE) + 1;
        int[] missing = IntStream.range(1, COUNT_MISSING + 1)
                .map(each -> rand.nextInt(NUM_MISSING_RANGE) + 1)
                .toArray();

        System.out.println("Missing random nums :" + Arrays.toString(missing));
        Predicate<Integer> doesNotExistInMissing =
                integer -> Arrays.stream(missing).noneMatch(each -> each==integer);

        System.out.println("Random Number is : " + randomNum + " Missing number is: " +
                getOnlyOneMissingNumber(IntStream.range(1, NUM_TOTAL_RANGE + 1).filter(i -> i != randomNum).toArray()));

        System.out.println("Missing numbers are :" + Arrays.toString(
                getMissingNumbers(
                        IntStream.range(1, NUM_TOTAL_RANGE + 1).filter(doesNotExistInMissing::test).toArray(),
                        NUM_TOTAL_RANGE)));
    }

    private static int getOnlyOneMissingNumber(int[] arr) {
        return (((NUM_TOTAL_RANGE * (NUM_TOTAL_RANGE + 1)) / 2) - Arrays.stream(arr).reduce((x, y) -> x + y).getAsInt());
    }

    //General way to get any number of missing numbers in any array
    //Doesn't work if the array can hold duplicate values
    private static int[] getMissingNumbers(int[] arr, int totalRange) {
        int missingCount = totalRange - arr.length;
        BitSet bitSet = new BitSet(totalRange);
        Arrays.stream(arr).forEach(n -> bitSet.set(n - 1));
        int lastMissingIndex = 0;
        int[] ret = new int[missingCount];
        for (int i = 0; i < missingCount; i++) {
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            ret[i] = ++lastMissingIndex;
        }
        return ret;
    }
}
