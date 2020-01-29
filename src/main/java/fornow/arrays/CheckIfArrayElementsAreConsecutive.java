package fornow.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//https://www.geeksforgeeks.org/check-if-array-elements-are-consecutive/
//Given an unsorted array of numbers, write a function that returns true if array consists of consecutive numbers.
//        Examples:
//        a) If array is {5, 2, 3, 1, 4}, then the function should return true because the array has consecutive numbers from 1 to 5.
//
//        b) If array is {83, 78, 80, 81, 79, 82}, then the function should return true because the array has consecutive numbers from 78 to 83.
//
//        c) If the array is {34, 23, 52, 12, 3 }, then the function should return false because the elements are not consecutive.
//
//        d) If the array is {7, 6, 5, 5, 3, 4}, then the function should return false because 5 and 5 are not consecutive.
public class CheckIfArrayElementsAreConsecutive {
    public static void main(String[] args)  {
        int[] arr1 = new int[]{5, 2, 3, 1, 4};
        int[] arr2 = new int[]{83, 78, 80, 81, 79, 82};
        int[] arr3 = new int[]{34, 23, 52, 12, 3};
        int[] arr4 = new int[]{7, 6, 5, 5, 3, 4};
        System.out.println("Array Elements are consecutive :" + navieWay(arr1));
        System.out.println("Array Elements are consecutive :" + navieWay(arr2));
        System.out.println("Array Elements are consecutive :" + navieWay(arr3));
        System.out.println("Array Elements are consecutive :" + navieWay(arr4));

        System.out.println("Array Elements are consecutive :" + anotherWay(arr1));
        System.out.println("Array Elements are consecutive :" + anotherWay(arr2));
        System.out.println("Array Elements are consecutive :" + anotherWay(arr3));
        System.out.println("Array Elements are consecutive :" + anotherWay(arr4));
    }

    private static Boolean navieWay(int[] arr) {
        Arrays.sort(arr);
        return ((arr[arr.length-1] - arr[0] + 1) == arr.length);
    }

    private static Boolean anotherWay(int[] arr)    {
        MinMax minMax = getArrayMinMax(arr);
        Set<Integer> mySet = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        return (((minMax.max - minMax.min + 1) == arr.length) && arr.length == mySet.size());
    }

    private static MinMax getArrayMinMax(int[] arr)  {
        MinMax minMax = new MinMax();
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > minMax.max) {
                minMax.max = arr[i];
            }
            if(arr[i] < minMax.min) {
                minMax.min = arr[i];
            }
        }
        return minMax;
    }

    static class MinMax {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }
}
