package fornow;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class LargestNSmallestInUnsortedArray {

    public static void main(String[] args) {
        int NUM_TOTAL_RANGE = 10;
        int NUM_RANDOM_RANGE = 100;
        Random rand = new Random();
        int[] arr = IntStream.range(1, NUM_TOTAL_RANGE + 1).map(each -> rand.nextInt(NUM_RANDOM_RANGE) + 1).toArray();
        printLargestNSmallest(arr);
        printLargestNSmallestUsingCollections(arr);
    }

    private static void printLargestNSmallest(int[] numbers)    {
        int largest = numbers[0], smallest = numbers[0];
        for(int i=0; i<numbers.length; i++) {
            if (numbers[i] > largest) largest = numbers[i];
            if (numbers[i] <= smallest) smallest = numbers[i];
        }
        System.out.println("Array is: " + Arrays.toString(numbers) +
                " Largest in Array :" + largest + " Smallest in Array :" + smallest);
    }

    private static void printLargestNSmallestUsingCollections(int[] numbers)    {
        TreeSet<Integer> tree = new TreeSet<>();
        Arrays.stream(numbers).forEach(each -> tree.add(each));
        System.out.println("Array is: " + Arrays.toString(numbers) +
                " Largest in Array :" + tree.last() + " Smallest in Array :" + tree.first());
    }
}
