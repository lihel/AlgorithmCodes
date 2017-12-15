package mypackage;

/**
 * Created by lmy on 17-12-15.
 */

import java.io.*;
import java.util.*;

class remove {
    public int removeElement(int[] nums, int val) {
        int temp, j = nums.length - 1;
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == val) {
                if (nums[j] != val) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    j--;
                    i++;
                } else {
                    j--;
                }
            }
            else i++;

            if (i == j) {
                System.out.println(i);
                nums = Arrays.copyOfRange(nums, 0, i);
                
            }
        }
        return nums.length;
    }
}

public class RemoveElement {
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

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int val = Integer.parseInt(line);

            int ret = new remove().removeElement(nums, val);
            String out = integerArrayToString(nums, ret);

            System.out.print(out);
        }
    }
}