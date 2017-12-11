package mypackage;

/**
 * Created by lmy on 17-12-11.
 */

import java.io.*;

class IntegertoRoma {
    public String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return "";
        }
        String res = "";
        int[] number = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 7, 5, 4, 1};
        String[] chars = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "VII", "V", "IV", "I"};
        for (int i = 0; i < number.length && num > 0; i++) {
            if (num < number[i]) continue;
            while (num >= number[i]) {
                num -= number[i];
                res += chars[i];
            }

        }
        return res;
    }
}

public class IntegertoRoman {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int num = Integer.parseInt(line);

            String ret = new IntegertoRoma().intToRoman(num);

            String out = (ret);

            System.out.print(out);
        }
    }
}