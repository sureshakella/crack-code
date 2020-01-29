package fornow.arrays;

import java.util.HashMap;
import java.util.Map;

public class LowestUniqueValueInArray {
    public static void main(String[] args) {
        int[] arr = new int[]{3,3,9,1,6,5,1,5,3,6,2};
        Map<Integer, Integer> map = new HashMap<>();
        int idx=-1;
        for(int i=0; i<arr.length; i++) {
            if (map.containsKey(arr[i]))  map.replace(arr[i], -1);
            else map.put(arr[i], i);
        }

        for(int i=0; i<arr.length; i++) {
            int val = map.get(arr[i]);
            if (val!= -1) {
                System.out.println("Index : " + val + " Value :" + arr[i]);
                break;
            }
        }
    }
}