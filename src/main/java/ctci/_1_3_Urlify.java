package ctci;

//URLify: Write a method to replace all spaces in a string with '%20:
// You may assume that the string has sufficient space at the end to
// hold the additional characters, and that you are given the "true"
// length of the string. (Note: If implementing in Java, please use a character array
// so that you can perform this operation in place.)

import java.util.Arrays;

public class _1_3_Urlify {
    public static void main(String[] args) {
        String s1 = "Mr John Smith    ";
        System.out.println("Actual String : "+ s1 + " , After urlify :" + Urlify(s1, 13));
        String s2 = "a ";
        System.out.println("Actual String : "+ s2 + " , After urlify :" + Urlify(s2, 1));
        String s3 = " ";
        System.out.println("Actual String : "+ s3 + " , After urlify :" + Urlify(s3, 0));
        String s4 = " a  ";
        System.out.println("Actual String : "+ s4 + " , After urlify :" + Urlify(s4, 1));
        String s5 = " a ";
        System.out.println("Actual String : "+ s5 + " , After urlify :" + Urlify(s5, 1));
    }

    private static String Urlify(String str, int truLength) {
        char[] arr = str.toCharArray();
        int spaceCnt = 0;
        for(int i=0;i<truLength;i++) {
            if(arr[i]==' ') spaceCnt++;
        }
        int j = (truLength+(spaceCnt*2))-1;
        if (j >= arr.length-1) return "Not enough spaces at end. Can't urlify";
        for(int i=truLength-1; i>=0;i--) {
            if(arr[i]==' ') {
                arr[j--]='0';
                arr[j--]='2';
                arr[j--]='%';
            }
            else {
                arr[j--] = arr[i];
            }
        }
        return String.valueOf(arr);
    }
}
