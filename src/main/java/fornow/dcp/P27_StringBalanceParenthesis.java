package fornow.dcp;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P27_StringBalanceParenthesis {
    static HashMap<Character, Character> charMap = new HashMap<>();

    public static void main (String[] args) {
        charMap.put('(', ')');
        charMap.put('[', ']');
//        Map<String, Long> stringMap =
//                Arrays.stream(strings).collect(
//                        Collectors.groupingBy(
//                                Function.identity(), Collectors.counting()
//                        )
//                );
//
//        // Function<String, Integer> existsInString =
//        return Arrays.stream(queries)
//                .map(q -> (Objects.nonNull(stringMap.get(q))) ? stringMap.get(q) :0l)
//                .mapToInt(Long :: intValue)
//                .toArray();


        System.out.println(isBalanced("This string has (balance) parenthesis"));
        System.out.println(isBalanced("This string (too) has [balance] parenthesis"));
        System.out.println(isBalanced("This string (also [has] balance) parenthesis"));
        System.out.println(isBalanced("This string (has no [balance) parenthesis]"));
        System.out.println(isBalanced("This string (too ]with no )balance[ parenthesis"));
    }

    private static boolean isBalanced(String input)    {
        Stack<Character> stack = new Stack<>();
        for(Character ch : input.toCharArray()) {
            if (charMap.keySet().contains(ch))  {
                stack.push(ch);
            } else if (charMap.values().contains(ch)){
                if(charMap.get(stack.peek()) == ch) {
                    stack.pop();
                }
                else {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
