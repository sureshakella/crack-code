package fornow;

import java.util.ArrayList;
import java.util.List;

public class FibonacciSeries {
    public static void main(String[] args) {
        int N = 6;
        Solution sol = new Solution(N);
        System.out.println(sol.fib(N));
    }

    public static class Solution {
        Integer[] cache;
        Solution(int N) {
            cache = new Integer[N+1];
        }

        public int fib(int N) {
            if (cache[N]!= null) return cache[N];
            int res;
            if (N ==0 || N ==1) res = N;
            else res = fib(N-1) + fib(N -2);
            cache[N]= res;
            return res;
        }
    }
}
