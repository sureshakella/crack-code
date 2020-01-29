package ctci;

//Is Unique: Implement an algorithm to determine if a string has all unique characters.
// What if you cannot use additional data structures?

import java.util.Arrays;
import java.util.BitSet;

public class _1_1_IsUnique {
    public static void main(String[] args) {
        String str ="sureh";
        String str1 ="suresh";
        System.out.println("Str :" + str + " has uniq characters - " + isUniqAscii(str));
        System.out.println("Str :" + str1 + " has uniq characters - " + isUniqAscii(str1));
        System.out.println("Str :" + " " + " has uniq characters - " + isUniqAscii(""));
        System.out.println("Str :" + str + " has uniq characters - " + isUniqAsciiBitSet(str));
        System.out.println("Str :" + str1 + " has uniq characters - " + isUniqAsciiBitSet(str1));
        System.out.println("Str :" + " " + " has uniq characters - " + isUniqAsciiBitSet(""));
        System.out.println("Str :" + str + " has uniq characters - " + isUniqNoAddDS(str));
        System.out.println("Str :" + str1 + " has uniq characters - " + isUniqNoAddDS(str1));
        System.out.println("Str :" + " " + " has uniq characters - " + isUniqNoAddDS(""));
    }

    private static boolean isUniqAscii(String str) {
        byte[] ascii = new byte[256];
        for(int i=0; i<str.length(); i++) {
            int num = Character.getNumericValue(str.charAt(i));
            if(ascii[num]!=0) return false;
            else ascii[num]++;
        }
        return true;
    }

    private static boolean isUniqAsciiBitSet(String str) {
        BitSet ascii = new BitSet(256);
        for(int i=0; i<str.length(); i++) {
            int num = Character.getNumericValue(str.charAt(i));
            if(ascii.get(num)) return false;
            else ascii.set(num);
        }
        return true;
    }

    private static boolean isUniqNoAddDS(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        for(int i=0; i<arr.length-1;i++) {
            if (arr[i]==arr[i+1]) return false;
        }
        return true;
    }
}
