package mypackage;

/**
 * Created by lmy on 17-12-9.
 * 给定一个罗马数字，将其转换为整数。 输入保证在1到3999的范围内。
 * I、V、X、L、C、D、M
 * 相应的阿拉伯数字表示为：
 * 1．5、10、50、100、500、1000
 * (1)相同的数字连写，所表示的数等于这些数字相加得到的数，如：Ⅲ = 3；
 * (2)小的数字在大的数字的右边，所表示的数等于这些数字相加得到的数， 如：Ⅷ = 8；Ⅻ = 12；
 * (3)小的数字，（限于Ⅰ、X 和C）在大的数字的左边，所表示的数等于大数减小数得到的数，如：Ⅳ= 4；Ⅸ= 9；
 * (4)正常使用时连写的数字重复不得超过三次。
 * (5)在一个数的上面画一条横线，表示这个数增值1000 倍。
 */

import java.io.*;
import java.util.HashMap;

class roma {
    public int romanToInt(String s) {

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;
        int weight = 0;
        int Now = 0;
        //从右往左遍历罗马数字，遇到权重weight大于等于它的temp,则result加上该weight,temp为当前权重
        for (int i = s.length() - 1; i >= 0; i--) {
            weight = map.get(s.charAt(i));
            if (Now <= weight) {
                result += weight;
                Now = weight;
            } else {
                result -= weight;
                Now = weight;
            }
        }
        return result;
    }
}

public class RomantoInteger {
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            int ret = new roma().romanToInt(s);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}