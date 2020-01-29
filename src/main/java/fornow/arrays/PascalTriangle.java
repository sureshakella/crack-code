package fornow.arrays;

//Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
//
//Note that the row index starts from 0.
//Example:
//
//Input: 3
//Output: [1,3,3,1]
//Follow up:
//
//Could you optimize your algorithm to use only O(k) extra space?
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {
        List<Integer> result = new ArrayList<>();
        getRow(result, 0, 32);
        System.out.println(Arrays.toString(result.toArray()));
    }

    private static void getRow(List<Integer> result, int currRow, int rowIndex) {
        if(currRow > rowIndex) return;
        result.add(1);
        for(int j = currRow-1; j>0; j--) {
//            System.out.print(j + "====" + (result.get(j-1) + result.get(j)));
//            System.out.println();
            result.set(j, result.get(j-1) + result.get(j));
        }
        System.out.println(Arrays.toString(result.toArray()));
        getRow(result, currRow+1, rowIndex);
    }
}
