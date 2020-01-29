package fornow.arrays;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        fourSum(new int[]{1,2,3,4,5,6,7},7);
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return Collections.EMPTY_LIST;
        }
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> subList = new ArrayList<>();
        findCombinations(set, subList, nums, 0, 0, target);
        return new ArrayList<>(set);
    }

    private static void findCombinations(Set<List<Integer>> set, List<Integer> subList, int[] nums, int sum, int start, int target) {
        if (subList.size() == 4) {
            if (sum == target) {
                set.add(new ArrayList<>(subList));
            }
            return;
        }

        for (int index = start; index < nums.length; index++) {
            subList.add(nums[index]);
            findCombinations(set, subList, nums, sum + nums[index], index+1, target);
            subList.remove(subList.size() - 1);
        }
    }
}
