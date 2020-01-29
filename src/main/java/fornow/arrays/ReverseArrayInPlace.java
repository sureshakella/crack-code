package fornow.arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class ReverseArrayInPlace {

    public static void main(String[] args)  {
        int NUM_TOTAL_RANGE = 13;
        int NUM_RANDOM_RANGE = 100;
        Random rand = new Random();
        int[] arr = IntStream.range(1, NUM_TOTAL_RANGE + 1).map(each -> rand.nextInt(NUM_RANDOM_RANGE) + 1).toArray();
        System.out.println("Array before reversing :" + Arrays.toString(arr));
        reverseInPlace(arr);
        System.out.println("Array after reversing :" + Arrays.toString(arr));
    }

    private static int[] reverseInPlace(int[] numbers)  {
        int temp;
        for(int i=0; i<numbers.length/2; i++) {
            temp = numbers[i];
            numbers[i] = numbers[numbers.length -1 - i];
            numbers[numbers.length -1 - i] = temp;
        }
        return numbers;
    }
}
