package mypackage;

/**
 * Created by lmy on 17-12-12.
 */

import java.util.*;
import java.io.*;

class valid {

    public boolean isValid(String s) {
        //HashMap的结构（key,value）,keySet()函数为获取所有的键key,返回一个数组
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.keySet().contains(c)) {
                stack.push(c);
            } else if (map.values().contains(c)) {
                if (!stack.empty() && map.get(stack.peek()) == c) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.empty();

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