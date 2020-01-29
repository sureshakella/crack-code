package fornow.dp;

public class ZeroOneKnapscak {
    public static void main(String[] args) {
        int[] values = new int[]{20,5,10,40,15,25};
        int[] weights = new int[]{1,2,3,8,7,4};
        System.out.println(knapsack(weights, values, 10));
    }

    private static int knapsack(int[] weights, int[] values, int capacity) {
        int n = values.length;
        int[][] T = new int[n+1][capacity+1];
        //for every value
        for(int i=1; i<=n; i++) {
            for(int j=0; j<=capacity; j++) {
                //Don't include the current item value as it's weight is more than capacity
                if(weights[i-1] > j) {
                    T[i][j] = T[i-1][j];
                }
                //Find the maximum of including the current item value vs excluding the current item value.
                else {
                    T[i][j] = Math.max(T[i-1][j], T[i-1][j - weights[i-1]] + values[i-1]);
                }
            }
        }
        return T[n][capacity];
    }
}
