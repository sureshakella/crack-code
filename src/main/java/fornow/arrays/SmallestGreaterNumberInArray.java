package fornow.arrays;

import java.util.*;
import java.util.stream.Stream;

public class SmallestGreaterNumberInArray {

    public static void main (String args[]) {
        acceptInputArgs(args);
    }

    static void acceptInputArgs(String[] args)   {
        int testCases = Integer.valueOf(args[0]);
        int[][] arr = new int[testCases][];
        for(int i=1,j=0; i+1 <= testCases *2; i+=2,j++) {
//            arr[j] = new int[Integer.valueOf(args[i])];
            arr[j] = Stream.of(args[i+1].replaceAll("\'","").split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(Arrays.toString(arr[0]));
        System.out.println(Arrays.toString(arr[1]));

        coreLogic(arr, testCases);
    }

    /**Input of below form
     * 2
     * 9
     * 6 3 9 8 10 2 1 15 7
     * 4
     * 13 6 7 12
     *
     * Input :  6 3 9 8 10 2 1 15 7
     * Output : 7 6 10 9 15 3 2 _ 8
     *
     * Input  : 13 6 7 12
     * Output : _ 7 12 13
     */
    static void acceptConsoleInput()    {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        int[][] arr = new int[testCases][];
        for(int j=0; j< testCases; j++) {
            String arrSize = scanner.nextLine();
            String line = scanner.nextLine();
            arr[j] = Stream.of(line.split(" "))
                    .filter(str -> !str.isEmpty())
                    .mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(Arrays.toString(arr[0]));
        System.out.println(Arrays.toString(arr[1]));

        coreLogic(arr, testCases);
    }

    static void coreLogic(int[][] arr, int testCases)  {
        String[][] ret = new String[testCases][];
        for(int i=0; i<arr.length; i++) {
            int[] copy = Arrays.copyOf(arr[i], arr[i].length);
            Arrays.sort(copy);
            HashMap<Integer, String> smallestGr8Map = new HashMap<>();
            for (int j=0; j < copy.length; j++)  {
                String value = (j+1 == copy.length) ? "_" : String.valueOf(copy[j+1]);
                smallestGr8Map.put(copy[j], value);
            }
            ret[i] = Arrays.stream(arr[i]).mapToObj(each -> smallestGr8Map.get(each)).toArray(String[]::new);
        }

        System.out.println(Arrays.toString(ret[0]));
        System.out.println(Arrays.toString(ret[1]));
    }

}
