package fornow.dp;

public class WaysOfCoinChangeForSum {
    public static void main(String[] args) {
        System.out.println(getWays(10, new int[]{1,2,5,3,6}));
    }

    private static int getWays(int amount, int[] coins) {
        int[] combinations = new int[amount+1];
        combinations[0]= 1;
        for(int coin : coins) {
            for(int total=1; total<=amount; total++) {
                if(total >= coin) combinations[total]+=combinations[total - coin];
            }
        }
        return combinations[amount];
    }
}
