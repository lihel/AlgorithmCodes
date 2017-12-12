package mypackage;

/**
 * Created by lmy on 17-12-12.
 */

import java.util.*;
import java.io.*;

class valid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        List<Character> left = new ArrayList<Character>();
        left.add('(');
        left.add('[');
        left.add('{');
        List<Character> right = new ArrayList<Character>();
        right.add(')');
        right.add(']');
        right.add('}');

        stack.push(s.charAt(0));

        for (int i = 0; i < s.length(); i++) {

            System.out.println("查看stack的栈顶元素为 : " + stack.peek());
            if (left.contains(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (right.contains(s.charAt(i))) {
                stack.pop();
            } else {

            }
        }
        if (stack.empty()) {
            return true;
        } else
            return false;
    }
}

public class ValidParentheses {
    public static String stringToString(String input) {
        assert input.length() >= 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < input.length() - 1; i++) {
            char currentChar = input.charAt(i);
            if (currentChar == '\\') {
                char nextChar = input.charAt(i + 1);
                switch (nextChar) {
                    case '\"':
                        sb.append('\"');
                        break;
                    case '/':
                        sb.append('/');
                        break;
                    case '\\':
                        sb.append('\\');
                        break;
                    case 'b':
                        sb.append('\b');
                        break;
                    case 'f':
                        sb.append('\f');
                        break;
                    case 'r':
                        sb.append('\r');
                        break;
                    case 'n':
                        sb.append('\n');
                        break;
                    case 't':
                        sb.append('\t');
                        break;
                    default:
                        break;
                }
                i++;
            } else {
                sb.append(currentChar);
            }
        }
        return sb.toString();
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            boolean ret = new valid().isValid(s);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}