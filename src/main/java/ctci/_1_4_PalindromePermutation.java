package ctci;

import java.util.BitSet;

//Given a string, write a function to check if it is a permutation of a palindrome.
// A palindrome is a word or phrase that is the same forwards and backwards.
// A permutation is a rearrangement of letters.The palindrome does not need to be
// limited to just dictionary words.
//Input: Tact Coa
//        Output: True (permutations: "taco cat". "atco cta". etc.)
public class _1_4_PalindromePermutation {
    public static void main(String[] args) {
        String str = "Tact Coa";
        System.out.println("String s : " + str + " is Palindrome permutation - " + isPalindromePermutation(str));
        String str1 = "suresh kumar";
        System.out.println("String s : " + str1 + " is Palindrome permutation - " + isPalindromePermutation(str1));
        String str2 = "nunrse rus"; //"nurses run"
        System.out.println("String s : " + str2 + " is Palindrome permutation - " + isPalindromePermutation(str2));
        String str3 = "atttar rtatat"; //"tattarrattat",
        System.out.println("String s : " + str3 + " is Palindrome permutation - " + isPalindromePermutation(str3));
    }

    private static boolean isPalindromePermutation(String str) {
        BitSet bitset = new BitSet(256);
        str = str.toLowerCase();
        for(int i=0; i<str.length();i++) {
            if (str.charAt(i) != ' ') {
                if (bitset.get(str.charAt(i))) bitset.clear(str.charAt(i));
                else bitset.set(str.charAt(i));
            }
        }
//        System.out.println("bitset " + bitset.cardinality() + " bitste is :" + bitset);
        if(bitset.cardinality() > 1) return false;
        else return true;


    }
}
