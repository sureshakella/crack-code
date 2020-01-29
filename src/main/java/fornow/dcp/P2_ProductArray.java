package fornow.dcp;

//Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
//
//        For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
//
//        Follow-up: what if you can't use division?

import java.util.Arrays;
import java.util.stream.IntStream;

public class P2_ProductArray {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5};
        int[] arr = {3, 2, 1};
        int totalProduct = IntStream.of(arr).reduce((num1, num2) -> num1 * num2).getAsInt();
        int[] result = IntStream.of(arr).map(each -> totalProduct/each).toArray();
        System.out.println(Arrays.toString(result));
        divisionRestriction(arr);
    }

    private static void divisionRestriction(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] product = new int[n];
        left[0] = 1;
        right[0] = 1;
        for(int i=1, j=n-1;i<n && j>=0;i++,j--) {
            left[i] = arr[i-1] * left[i-1];
            right[i] = arr[j] * right[i-1];
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        for(int i=0; i<n;i++) {
            product[i] = left[i] * right[n-i-1];
        }
        System.out.println(Arrays.toString(product));
    }
}
