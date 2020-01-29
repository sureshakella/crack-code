package fornow.arrays;

//Given an array, the task is to calculate the sum of lengths of contiguous subarrays having all elements distinct.
//Input :  arr[] = {1, 2, 3}
//        Output : 10
//        {1, 2, 3} is a subarray of length 3 with
//        distinct elements. Total length of length
//        three = 3.
//        {1, 2}, {2, 3} are 2 subarray of length 2
//        with distinct elements. Total length of
//        lengths two = 2 + 2 = 4
//        {1}, {2}, {3} are 3 subarrays of length 1
//        with distinct element. Total lengths of
//        length one = 1 + 1 + 1 = 3
//        Sum of lengths = 3 + 4 + 3 = 10
//
//        Input :  arr[] = {1, 2, 1}
//        Output : 7
//
//        Input :  arr[] = {1, 2, 3, 4}
//        Output : 20

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SubArraysWithDistinctElements {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(countOfLengthOfSubArraysWithDistinctElem(arr));
        int[] arr1 = {1, 2, 1};
        System.out.println(countOfLengthOfSubArraysWithDistinctElem(arr1));
        int[] arr2 = {1, 2, 3, 4};
        System.out.println(countOfLengthOfSubArraysWithDistinctElem(arr2));
    }

    public static int countOfLengthOfSubArraysWithDistinctElem(int[] elems) {
        int itr =2;
        int sum = elems.length;
        while(itr <= elems.length) {
            for(int i=0; (i + itr)<=elems.length; i++) {
                if (isDistinct(Arrays.copyOfRange(elems, i, i+itr))) {
                    sum+=itr;
                }
            }
            itr++;
        }
        return sum;
    }

    public static boolean isDistinct(int[] subArr) {
        return (subArr.length == IntStream.of(subArr).boxed().collect(Collectors.toSet()).size());
    }
}
