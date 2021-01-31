package chapter1.Section04;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Sharon
 * @date 2021-01-28 https://leetcode-cn.com/problems/open-the-lock/
 */
public class OpenTheLock {

    public int openLock(String[] deadends, String target) {
        String initCode = "0000";
        if (initCode.equals(target)) {
            return 0;
        }
        Set<String> deadend = new HashSet<>();
        Collections.addAll(deadend, deadends);
        int step = 0;
        Set<String> startSet = new HashSet<>();
        Set<String> targetSet = new HashSet<>();
        saveCurResult(initCode, startSet, deadend);
        saveCurResult(target, targetSet, deadend);
        while (!startSet.isEmpty() && !targetSet.isEmpty()) {
            step++;
            if (trySpinButton(startSet, targetSet, deadend)) {
                return step;
            }
            step++;
            if (trySpinButton(targetSet, startSet, deadend)) {
                return step;
            }
        }
        return -1;
    }

    private boolean trySpinButton(Set<String> startSet, Set<String> targetSet, Set<String> deadend) {
        Set<String> backupSet = new HashSet<>();
        int buttonCount = 4;
        String curCode;
        for (String string : startSet) {
            for (int j = 0; j < buttonCount; j++) {
                curCode = spinButton(string, j, 1);
                if (targetSet.contains(curCode)) {
                    return true;
                }
                saveCurResult(curCode, backupSet, deadend);
                curCode = spinButton(string, j, -1);
                if (targetSet.contains(curCode)) {
                    return true;
                }
                saveCurResult(curCode, backupSet, deadend);
            }
        }
        startSet.clear();
        startSet.addAll(backupSet);
        return false;
    }

    private String spinButton(String s, int position, int direction) {
        char[] nums = s.toCharArray();
        int num = (nums[position] - '0' + direction + 10) % 10;
        nums[position] = (char)(num + '0');
        return new String(nums);
    }

    private void saveCurResult(String code, Set<String> set, Set<String> deadend) {
        if (!deadend.contains(code)) {
            set.add(code);
            deadend.add(code);
        }
    }

    public static void main(String[] args) {
        OpenTheLock test = new OpenTheLock();
        String[] deadends = new String[] {"0201", "0101", "0102", "1212", "2002"};
        System.out.println(test.openLock(deadends, "0202"));
    }

}
