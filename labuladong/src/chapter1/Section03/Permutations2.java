package chapter1.Section03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sharon
 * @date 2021-01-28 https://leetcode-cn.com/problems/permutations-ii/
 */
public class Permutations2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] mark = new boolean[nums.length];
        Arrays.sort(nums);
        permuteUnique(nums, mark, 0, new ArrayList<>(), result);
        return result;
    }

    private void permuteUnique(int[] nums, boolean[] mark, int level, ArrayList<Integer> list,
        List<List<Integer>> result) {
        if (level == nums.length) {
            result.add(new ArrayList<>(list));
        }
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i != 0 && mark[i - 1] & nums[i] == nums[i - 1]) {
                continue;
            }
            if (!mark[i]) {
                mark[i] = true;
                if (list.size() == level) {
                    list.add(nums[i]);
                } else {
                    list.set(level, nums[i]);
                }
                permuteUnique(nums, mark, level + 1, list, result);
                mark[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Permutations2 test = new Permutations2();
        System.out.println(test.permuteUnique(new int[] {1, 1, 2}));
    }

}
