package fornow;

import java.util.regex.Pattern;

//Given a 32-bit signed integer, reverse digits of an integer.
//
//        Example 1:
//
//        Input: 123
//        Output: 321
//        Example 2:
//
//        Input: -123
//        Output: -321
//        Example 3:
//
//        Input: 120
//        Output: 21
//        Note:

//"-91283472332"
//"2147483648"
//        Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
//        For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
public class Reverse32BitInteger {
    public static void main(String args[])  {
        System.out.println(reverse(123));
        System.out.println(reverse(-321));
        System.out.println(reverse(-1234567878));
        System.out.println(reverse(0));
        System.out.println(anotherReverse(123));
        System.out.println(anotherReverse(-321));
        System.out.println(anotherReverse(-1234567878));
        System.out.println(anotherReverse(0));
    }

    //Their solution - not one easily understandable
    private static int reverse(int x) {
        int rev = 0;
        while(x != 0){
            int res = x % 10;
            x = x / 10;
            if((rev > Integer.MAX_VALUE/ 10) || (rev == Integer.MAX_VALUE / 10 && res > 7)) return 0;
            if((rev < Integer.MIN_VALUE/ 10) || (rev == Integer.MIN_VALUE / 10 && res < -8)) return 0;
            rev = rev * 10 + res;
        }
        return rev;
    }

    //More intuitive solution
    private static int anotherReverse(int x)    {
        int rev = 0;
        while(x != 0){
            int res = x % 10;
            x = x / 10;
            int temp = rev * 10 + res;
            if((temp - res ) / 10 != rev) return 0;
            rev = temp;
        }
        return rev;

    }
}
