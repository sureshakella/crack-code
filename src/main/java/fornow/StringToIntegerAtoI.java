package fornow;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Implement atoi which converts a string to an integer.
//
//        The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
//
//        The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
//
//        If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
//
//        If no valid conversion could be performed, a zero value is returned.
//
//        Note:
//
//        Only the space character ' ' is considered as whitespace character.
//        Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
//        Example 1:
//
//        Input: "42"
//        Output: 42
//        Example 2:
//
//        Input: "   -42"
//        Output: -42
//        Explanation: The first non-whitespace character is '-', which is the minus sign.
//        Then take as many numerical digits as possible, which gets 42.
//        Example 3:
//
//        Input: "4193 with words"
//        Output: 4193
//        Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
//        Example 4:
//
//        Input: "words and 987"
//        Output: 0
//        Explanation: The first non-whitespace character is 'w', which is not a numerical
//        digit or a +/- sign. Therefore no valid conversion could be performed.
//        Example 5:
//
//        Input: "-91283472332"
//        Output: -2147483648
//        Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
//        Thefore INT_MIN (−231) is returned.

public class StringToIntegerAtoI {
    public static void main(String[] args) {
        String s = "-42";
        System.out.println(myAtoi(s));
        System.out.println(betterAtoi("-91283472332"));
        System.out.println(betterAtoi("2147483648"));
        System.out.println(betterAtoi("-42"));
    }

    public static int myAtoi(String str) {
        Pattern p = Pattern.compile("^\\s*[+-]?\\d+");
        Matcher matcher = p.matcher(str);
        Integer ret = 0;
        if (matcher.find())  {
            String value = matcher.group().trim();
            try {
                ret = Integer.valueOf(value);
            }
            catch(NumberFormatException nfe)    {
                ret = value.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return ret;
    }

    public static int betterAtoi(String original)    {
        String str = original.trim();
        if(str.isEmpty()) return 0;
        int val = 0, temp =0;
        char first = str.charAt(0);
        if(!isAllowedChar(first) && !Character.isDigit(first))   return 0;
        for(int i=0; i< str.length() && (i==0 || Character.isDigit(str.charAt(i))); i++)  {
            if (Character.isDigit(str.charAt(i)))   {
                int res = Character.getNumericValue(str.charAt(i));
                temp = val * 10 + res;
                if((val > Integer.MAX_VALUE/ 10) || (val == Integer.MAX_VALUE / 10 && res > 7)) {
                    return  (first == '-') ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                if((val < Integer.MIN_VALUE/ 10) || (val == Integer.MIN_VALUE / 10 && res < -8)) return Integer.MIN_VALUE;
                val = temp;
            }
        }
        return (first == '-') ? -1 * val : val;
    }

    private static boolean isAllowedChar(char first)  {
        return (first == '+' || first == '-' );
    }
}
