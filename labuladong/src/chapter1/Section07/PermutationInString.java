package chapter1.Section07;

/**
 * https://leetcode-cn.com/problems/permutation-in-string/
 *
 * @author Blank
 * @date 2021/01/31 18:45
 **/
public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        int[] window = new int[26], target = new int[26];
        for (char c : s1.toCharArray()) {
            target[c - 'a']++;
        }
        char[] sArr = s2.toCharArray();
        int windowStart = 0, mark;
        for (int i = 0; i < s2.length(); i++) {
            // sliding window
            mark = sArr[i] - 'a';
            window[mark]++;
            // check the window whether contains the target
            if (window[mark] == target[mark] && i - windowStart + 1 == s1.length()) {
                return true;
            }
            // clear the window before the char first be found
            if (window[mark] > target[mark]) {
                while (windowStart < i && sArr[windowStart] != sArr[i]) {
                    window[sArr[windowStart++] - 'a']--;
                }
                window[sArr[windowStart++] - 'a']--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PermutationInString test = new PermutationInString();
        System.out.println(test.checkInclusion("ab", "eidbaooo"));
        System.out.println(test.checkInclusion("ab", "eidboaoo"));
    }

}
