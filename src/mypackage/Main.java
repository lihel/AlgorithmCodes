package mypackage;

/**
 * Created by lmy on 17-11-12.
 */

/*
一个由小写字母组成的字符串可以看成一些同一字母的最大碎片组成的。
例如,"aaabbaaac"是由下面碎片组成的:'aaa','bb','c'。
现在给定一个字符串,请你帮助计算这个字符串的所有碎片的平均长度是多少。
输入：aaabbaaac
输出：2.25
*/

import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        float n = 1;
        for (int i = 1; i < str.length(); i++) {

            if (str.charAt(i) != str.charAt(i - 1)) {
                n++;
            }

        }
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(df.format(str.length() / n));

    }
}