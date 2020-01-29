package fornow;

import java.util.*;

import static java.util.Objects.nonNull;

public class KLengthSubSequenceWithDistinctCharsFromString {
    public static void main(String[] args)  {
        //Inputs -- Can be taken from System.in or args
        String original = "abcereferepikerekfdopimndqmefdfer";
        int k =3;

        //Program variables
        Set<String> listall = new LinkedHashSet<>();
        int size = original.length();
        for(int i=0; i < size - k +1; i++) {
            String subStr = original.substring(i,i + k);
            if(nonNull(fetchSubSeq(original, i, i+k))) {
                listall.add(subStr);
            }
        }

        System.out.println(Arrays.toString(listall.toArray()));
    }

    public static String fetchSubSeq(String string, int begin, int len)  {
        String ret = "";
        for(int i=begin; i<len; i++)   {
            if(ret.indexOf(string.charAt(i)) != -1) {
                return null;
            }
            else {
                ret = ret + string.charAt(i);
            }
        }
        return ret;
    }
}


//Time Complexity O(NUM_TOTAL_RANGE)
//Space Complexity