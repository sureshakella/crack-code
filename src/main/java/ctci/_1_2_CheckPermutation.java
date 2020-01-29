package ctci;

//Check Permutation: Given two strings,
// write a method to decide if one is a permutation of the other.
public class _1_2_CheckPermutation {

    public static void main(String[] args) {
        String s1 = "suresh";
        String s2 = "ursshe";
        String s3 = "sureht";
        System.out.println("s1: " + s1 + " is permutation of s2: " + s2 + " -- " + isPermutation(s1, s2));
        System.out.println("s1: " + s3 + " is permutation of s2: " + s2 + " -- " + isPermutation(s3, s2));
    }

    private static boolean isPermutation(String s1, String s2) {
        if (s1.length()!= s2.length()) return false;
        byte[] ascii = new byte[256];
        for(int i=0; i<s1.length(); i++) {
            ascii[s1.charAt(i)]++;
        }
        for(int i=0; i<s1.length(); i++) {
            ascii[s2.charAt(i)]--;
            if(ascii[s2.charAt(i)] <0) return false;
        }
        for(int i=0; i<256;i++) {
            if(ascii[i]>0) return false;
        }
        return true;
    }
}
