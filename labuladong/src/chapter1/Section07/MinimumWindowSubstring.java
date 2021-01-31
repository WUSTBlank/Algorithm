package chapter1.Section07;

/**
 * https://leetcode-cn.com/problems/minimum-window-substring/
 *
 * @author Blank
 * @date 2021/01/31 13:58
 **/
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        // use array is better than map
        int[] window = new int[53];
        int[] target = new int[53];
        int valid = 0, mark;
        for (char c : t.toCharArray()) {
            mark = dealCharValue(c);
            if (target[mark] == 0) {
                valid++;
            }
            target[mark]++;
        }
        char[] sArr = s.toCharArray();
        int windowLeft = 0, windowRight = 0, len = s.length();
        int targetLeft = 0, targetRight = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            // sliding window
            mark = dealCharValue(sArr[windowRight++]);
            window[mark]++;
            if (target[mark] != 0 && window[mark] == target[mark]) {
                valid--;
            }
            // try to shrink window
            if (valid == 0) {
                // shrink window
                mark = dealCharValue(sArr[windowLeft]);
                while (window[mark] > target[mark]) {
                    window[mark]--;
                    mark = dealCharValue(sArr[++windowLeft]);
                }
                // update result
                if (targetRight - targetLeft > windowRight - windowLeft) {
                    targetLeft = windowLeft;
                    targetRight = windowRight;
                }
            }
        }
        return targetRight == Integer.MAX_VALUE ? "" : s.substring(targetLeft, targetRight);
    }

    private int dealCharValue(char c) {
        char lowerStart = 'a', lowerEnd = 'z';
        char upperStart = 'A', upperEnd = 'Z';
        if (c >= lowerStart && c <= lowerEnd) {
            return c - 'a';
        } else if (c >= upperStart && c <= upperEnd) {
            return c - 'A' + 26;
        } else {
            return 52;
        }
    }

    public static void main(String[] args) {
        MinimumWindowSubstring test = new MinimumWindowSubstring();
        System.out.println(test.minWindow("ABC", "BC"));
    }

}
