package fornow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NonRepeatCharInString {

    public static void main(String [] args) {
        System.out.println(getPerformantFirstNonRepeatChat("suresh"));
        System.out.println(getPerformantFirstNonRepeatChat("sureshkumar"));
        System.out.println(getPerformantFirstNonRepeatChat("suusrertet"));
    }

    //Not a efficient way as it creates too many string for each input string
    public static char getFirstNonRepeatChar(String str)   {
        for (int i = 0; i <str.length();)   {
            if (str.substring(i + 1).contains("" + str.charAt(i)))   {
                str = str.replace("" + str.charAt(i), "");
            }
            else {
                return str.charAt(i);
            }
        }
        return '0';
    }

    //Efficient way
    public static char getPerformantFirstNonRepeatChat(String str)  {
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        for(int i=0; i< str.length(); i++)  {
            int val = 0;
            if(charCountMap.containsKey(str.charAt(i))) {
                val = charCountMap.get(str.charAt(i));
            }
            charCountMap.put(str.charAt(i), val + 1);
        }
        for(int i=0; i<str.length(); i++) {
            if(charCountMap.get(str.charAt(i)) == 1)    {
                return str.charAt(i);
            }
        }
        return '0';
    }

}

