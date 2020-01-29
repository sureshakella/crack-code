package fornow.dcp;//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
//        You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//        Example:
//
//        Given nums = [2, 7, 11, 15], target = 9,
//
//        Because nums[0] + nums[1] = 2 + 7 = 9,
//        return [0, 1].

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P1_TwoSum {

    public static int[] notPeformantFindTwoSum(int[] list, int sum) {
        for(int i=0; i < list.length; i++)    {
            for(int j=i+1; j < list.length; j++)  {
                if (list[i] + list[j] == sum) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    public static int[] SuperAwesomeTwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public static int[] peformantFindTwoSum(int[] list, int sum) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : list) {
            int count = map.containsKey(num) ? map.get(num) : 0;
            map.put(num, count + 1);
        }
        System.out.println(Arrays.toString(map.entrySet().toArray()));
        boolean found = false;
        int idxOne = -1;
        int residue, secondNum = 0;
        for(int currIdx=0; currIdx < list.length; currIdx++)    {
            residue = sum - list[currIdx];
            if (!found && map.containsKey(residue))  {
                //Making sure that if `sum` is number added to itself, it's accounted for
                if(list[currIdx] != residue || (list[currIdx] == residue && map.get(list[currIdx]) == 2))   {
                    found = true;
                    idxOne = currIdx;
                    secondNum = residue;
                }
            }
            if(found && idxOne != currIdx && list[currIdx] == secondNum)  {
                return new int[]{idxOne, currIdx};
            }
        }
        return null;
    }

    public static void main (String[] args) {
        int[] indices = SuperAwesomeTwoSum(new int[] {5, 1, 3, 6, 6, 9}, 10);
        if(indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }
    }
}
