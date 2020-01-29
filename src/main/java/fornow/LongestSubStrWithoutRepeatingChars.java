package fornow;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class LongestSubStrWithoutRepeatingChars {

    public static void main(String[] args)  {
        String s = "abcabcbb";
        String s1 = "pwwkew";
        String s2 = "bbbb";
        String s3 = " ";
        System.out.println("Length of longest subsequence: " + coreLogic(s));
        System.out.println("Length of longest subsequence: " + coreLogic(s1));
        System.out.println("Length of longest subsequence: " + coreLogic(s2));
        System.out.println("Length of longest subsequence: " + coreLogic(s3));
    }

    //Creates too many strings/substrings
    private static int coreLogic(String s)  {
        TreeMap<Integer, String> subStrMap = new TreeMap<>();
        String subStr = new String();
        for(int i=0; i<s.length(); i++) {
            while(subStr.indexOf(s.charAt(i)) != -1)    {
                subStrMap.put(subStr.length(), subStr);
                subStr = subStr.substring(1);
            }
            subStr = subStr + "" + s.charAt(i);
        }
        subStrMap.put(subStr.length(), subStr);
        return subStrMap.isEmpty() ? 0 : subStrMap.lastKey();
    }



}
