package chapter1.Section06;

/**
 * https://leetcode-cn.com/problems/binary-search/
 *
 * @author Blank
 * @date 2021/01/31 13:31
 **/
public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch test = new BinarySearch();
        System.out.println(test.search(new int[] {-1, 0, 3, 5, 9, 12}, 3));
        System.out.println(test.search(new int[] {-1, 0, 3, 5, 9, 12}, 15));
    }
}
