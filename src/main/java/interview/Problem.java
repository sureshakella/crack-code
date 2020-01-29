package interview;

//String balance parentheses
//
//        “This string has (balance) parenthesis”
//        “This string (too) has [balance] parenthesis”
//        “This string (also [has] balance) parenthesis”
//        “This string (has no [balance) parenthesis]”
//        “This string (too ]with no )balance[ parenthesis”


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Problem {

    static Map<Character, Character> characterMap = new HashMap<>();

    public static void main(String[] args)  {
        characterMap.put(')', '(');
        characterMap.put(']', '[');

        System.out.println(isBalanced("This string (has no [balance) parenthesis]"));
    }

    private static boolean isBalanced(String input)
    {
        Stack<Character> status = new Stack<>();

        for (char c : input.toCharArray())
        {
            if (isInArray(c, true))
            {
                status.push(c);
            }

            if (isInArray(c, false))
            {
                char top = status.peek();

                if (top == characterMap.get(c))
                {
                    status.pop();
                }
                else
                {
                    return false;
                }
            }
        }

        return status.empty();
    }

    private static boolean isInArray(char target, boolean open)
    {
        if (open)
        {
            return characterMap.containsValue(target);
        }
        else {
            return characterMap.containsKey(target);
        }
    }
}
