package fornow;

import java.util.Arrays;

public class ReverseString {

    public static void main(String [] args) {
        System.out.println(recursiveReverse("The quick brown fox"));
        System.out.println(recursiveReverse("sureshkumar"));
        System.out.println(recursiveReverse("suusrertet"));
        System.out.println(iterativeReverse("The quick brown fox"));
        System.out.println(iterativeReverse("sureshkumar"));
        System.out.println(iterativeReverse("suusrertet"));
        System.out.println(evenSimpleReverse("The quick brown fox"));
        System.out.println(evenSimpleReverse("sureshkumar"));
        System.out.println(evenSimpleReverse("suusrertet"));
        System.out.println(new StringBuilder("The quick brown fox").reverse().toString());
        System.out.println(new StringBuilder("sureshkumar").reverse().toString());
        System.out.println(new StringBuilder("suusrertet").reverse().toString());
        System.out.println(inPlaceRecursiveReverse("The quick brown fox"));
        System.out.println(inPlaceRecursiveReverse("sureshkumar"));
        System.out.println(inPlaceRecursiveReverse("suusrertet"));
    }

    public static String recursiveReverse(String str)    {
        if(str.length() == 1)   {
            return str;
        }else {
            return str.charAt(str.length() - 1) + recursiveReverse(str.substring(0, str.length() -1));
        }
    }

    //Good when
    public static String iterativeReverse(String str)    {
        char[] arr = str.toCharArray();
        for(int i =0; i< arr.length/2; i++) {
            char tmp = arr[i];
            arr[i] = arr[arr.length - (i +1)];
            arr[arr.length - (i+1)] = tmp;
        }
        return String.valueOf(arr);
    }

    //But this creates too many string
    public static String evenSimpleReverse(String str)  {
        StringBuilder sb  = new StringBuilder();
        for(int i = str.length() -1; i >= 0; i--)   {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static String inPlaceRecursiveReverse(String str) {
        char[] strArr = str.toCharArray();
        recursiveHelper(strArr, 0, strArr.length-1);
        return String.valueOf(strArr);
    }

    private static void recursiveHelper(char[] s, int start , int end) {
        if (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            recursiveHelper(s, start + 1, end -1);
        }
    }
}
