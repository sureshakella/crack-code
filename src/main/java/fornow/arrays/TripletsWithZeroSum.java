package fornow.arrays;

import java.util.HashSet;
import java.util.Set;

public class TripletsWithZeroSum {
    public static void main(String[] args) {
        int arr[] = {0, -1, 2, -3, 1};
        for(int i=0; i<arr.length-1;i++) {
            Set<Integer> exists = new HashSet<>();
            for(int j=i+1; j<arr.length;j++) {
                int residue = -(arr[i] + arr[j]);
                if (exists.contains(residue)) {
                    System.out.println(arr[i] + " " + arr[j] + " " + residue);
                }
                else exists.add(arr[j]);
            }
        }
    }
}
