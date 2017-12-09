package mypackage;

/**
 * Created by lmy on 17-12-9.
 * 判断输入的数字是否为回文数如123321返回true,123返回false
 */

import java.io.*;

public class HuiWenNumber {
    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);

            boolean ret = new Huiwen().isPalindrome(x);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}

class Huiwen {
    public boolean isPalindrome(int x) {
        String str=x+"";
        String reverse = new StringBuffer(str).reverse().toString();
        if(x > Integer.MAX_VALUE||x<Integer.MIN_VALUE){
            return false;
        }
        if(str.compareTo(reverse)==0){
            return true;
        }
        return false;

    }
}

