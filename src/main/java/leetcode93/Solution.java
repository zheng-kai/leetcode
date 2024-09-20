package leetcode93;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    List<String> res = new LinkedList<>();
    LinkedList<Integer> address = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        addSegment(s, 0);
        return res;
    }

    public void addSegment(String s, int startIndex) {
        if (address.size() == 4) {
            if (startIndex == s.length()) {
                StringBuilder sb = new StringBuilder();
                int i = 0;
                for (; i < address.size() - 1; i++) {
                    sb.append(address.get(i));
                    sb.append(".");
                }
                sb.append(address.get(i));
                res.add(sb.toString());
            }
            return;
        }
        if (startIndex >= s.length()) {
            return;
        }
        char c = s.charAt(startIndex);
        if (c == '0') {
            address.add(0);
            addSegment(s, startIndex + 1);
            address.removeLast();
            return;
        }
        int seg = 0;
        for (int i = startIndex; i < s.length(); i++) {
            c = s.charAt(i);
            seg = seg * 10 + (c - '0');
            if (seg >= 0 && seg <= 255) {
                address.add(seg);
                addSegment(s, i + 1);
                address.removeLast();
            } else {
                return;
            }
        }
    }
}