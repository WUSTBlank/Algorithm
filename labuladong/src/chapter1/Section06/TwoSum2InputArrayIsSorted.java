package chapter1.Section06;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * @author Blank
 * @date 2021/01/31 13:40
 **/
public class TwoSum2InputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1, sum;
        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return new int[] {left + 1, right + 1};
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        TwoSum2InputArrayIsSorted test = new TwoSum2InputArrayIsSorted();
        System.out.println(Arrays.toString(test.twoSum(new int[] {2, 7, 11, 15}, 26)));
    }

}
