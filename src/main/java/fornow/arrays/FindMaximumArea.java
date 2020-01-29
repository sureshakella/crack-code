package fornow.arrays;
//                                            |
//                            |               |
//                            |---------------|       |
//                            |               |       |
//                            |   |           |       |
//                            |   |   |       |       |
//                            |   |   |   |   |       |
//                            |   |   |   |   |   |   |
//                        |   |   |   |   |   |   |   |
//                        |   |   |   |   |   |   |   |
//                        -----------------------------
//                        1   2   3   4   5   6   7   8
//
//-- To find the area that can hold maximum amount of water.
//        -- Formula for computing area : x * Y (distance between two pillars)
//        -- No cutting through pillars.
//
//        int[] arr = new int[]{2,8,6,5,4,10,3,9};

public class FindMaximumArea {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{2,8,6,5,4,10,3,9}));
        System.out.println(getMaxRainwaterBetweenTowers(new int[]{2,8,6,5,4,10,3,9}));
        System.out.println("========================================");
        System.out.println(findWater(new int[]{2,8,6,5,4,10,3,9}));
    }

    private static int maxArea(int[] arr) {
        int max = 0;
        for(int i=0, j=arr.length-1; i<j;) {
            System.out.print("i :" + i + "j :" + j);
            max = Math.max(max,Math.min(arr[i], arr[j]) * (j-i));
            if (arr[i] < arr[j])   {
                i = i+1;
            }
            else {
                j = j-1;
            }
            System.out.println("  area :" + max);
        }
        return max;
    }

    public static int getMaxRainwaterBetweenTowers(int[] towerHeight) {

        int[] maxSeenSoFarFromRight = new int[towerHeight.length];

        //Populate maxSeenSoFarFromRight array.
        maxSeenSoFarFromRight[towerHeight.length-1] = towerHeight[towerHeight.length-1];
        for (int i = towerHeight.length-2; i >= 0; i--) {
            maxSeenSoFarFromRight[i] = Math.max(maxSeenSoFarFromRight[i+1], towerHeight[i]);
        }

        int totalWaterCollection = 0;

        int maxSeenSoFarFromLeft = 0;
        for (int i = 0; i < towerHeight.length; i++) {
            if(maxSeenSoFarFromLeft < towerHeight[i]){
                maxSeenSoFarFromLeft = towerHeight[i];
            }
            int minFromLeftRight = Math.min(maxSeenSoFarFromLeft, maxSeenSoFarFromRight[i]);
            totalWaterCollection += (minFromLeftRight - towerHeight[i]);
        }
        return totalWaterCollection;
    }

    public static int findWater(int arr[])
    {
        // initialize output
        int result = 0;

        // maximum element on left and right
        int left_max = arr[0], right_max = arr[arr.length-1];

        // indices to traverse the array
        int lo = 0, hi = arr.length-1;

        while(lo < hi)
        {
            System.out.print(" low :" + lo + " high :" + hi);
            if(arr[lo] < arr[hi])
            {
                if(arr[lo] > left_max)
                    // update max in left
                    left_max = arr[lo];
//                    result = (hi-lo)* Math.min(left_max, right_max);
//                }
                else
                    // water on curr element = max - curr
                    result += left_max - arr[lo];
                lo++;
            }
            else
            {
                if(arr[hi] > right_max)
                    // update right maximum
                    right_max = arr[hi];
                else
                    result += right_max - arr[hi];
//                result = (hi-lo)* Math.min(left_max, right_max);
                hi--;
            }
//            result = (hi-lo)* Math.min(left_max, right_max);
            System.out.print(" left_max :" + left_max + " right_max :"
                    + right_max + " result :" + result);

            System.out.println();
        }
        return result;
//        new int[]{2,8,6,5,4,10,3,9};
    }
}
