package mypackage;
import java.io.*;
/**
 * Created by lmy on 17-12-9.
 * 反转十进制整数,溢出返回０
 */
class Solution {
    public int reverse(int x) {

        long result = 0;
        int tmp = Math.abs(x);
        while(tmp>0){
            result *= 10;
            result += tmp % 10;
            if(result > Integer.MAX_VALUE||result<Integer.MIN_VALUE){
                return 0;
            }
            tmp /= 10;
        }
        return (int)(x>=0?result:-result);
    }
}

public class ReserveNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);

            int ret = new Solution().reverse(x);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
