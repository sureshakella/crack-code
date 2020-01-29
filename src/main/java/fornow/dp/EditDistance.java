package fornow.dp;

public class EditDistance {
    public static void main(String[] args) {
        System.out.println("Distance is :" + getDistance("kitten", "sitting"));
    }

    private static int getDistance(String X, String Y) {
        int m = X.length(), n = Y.length();
        int[][] T = new int[m+1][n+1];

        //source prefixes transformed into empty string by dropping all characters
        for(int i=1; i<=m; i++) {
            T[i][0] = i;
        }
        //target prefixes copied into empty source string by inserting every character
        for(int j=1; j<=n; j++) {
            T[0][j] = j;
        }
        int cost;
        for(int i=1; i<=m;i++) {
            for (int j=1; j<=n; j++) {
                if(X.charAt(i-1) == Y.charAt(j-1)) cost=0;
                else cost = 1;
                T[i][j] = Integer.min(T[i-1][j] +1, Integer.min(T[i][j-1]+1, T[i-1][j-1]+cost));
            }
        }
        return T[m][n];
    }
}
