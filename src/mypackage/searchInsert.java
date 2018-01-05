package mypackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by lmy on 18-1-5.
 */

class searchIN {
    public int searchInsert(int[] nums, int target) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[0] > target) {
                return 0;
            }
            if (nums[i] == target) {
                index = i;
                return index;
            } else if (nums[i] > target) {
                return i;
            } else if (nums[nums.length - 1] < target) {
                return nums.length;
            }
        }
        return index;
    }
}

public class searchInsert {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);

            int ret = new searchIN().searchInsert(nums, target);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}