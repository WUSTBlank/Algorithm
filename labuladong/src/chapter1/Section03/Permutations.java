package chapter1.Section03;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sharon
 * @date 2021-01-28 https://leetcode-cn.com/problems/permutations/
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] mark = new boolean[nums.length];
        permute(nums, mark, 0, new ArrayList<>(), result);
        return result;
    }

    private void permute(int[] nums, boolean[] mark, int level, ArrayList<Integer> list, List<List<Integer>> result) {
        if (level == nums.length) {
            result.add(new ArrayList<>(list));
        }
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (!mark[i]) {
                mark[i] = true;
                if (list.size() == level) {
                    list.add(nums[i]);
                } else {
                    list.set(level, nums[i]);
                }
                permute(nums, mark, level + 1, list, result);
                mark[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Permutations test = new Permutations();
        System.out.println(test.permute(new int[] {1, 2, 3}));
    }

}
