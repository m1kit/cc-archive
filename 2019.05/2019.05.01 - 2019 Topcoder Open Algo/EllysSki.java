package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.util.ArrayUtil;

public class EllysSki {
    public int getMax(int[] height) {
        int n = height.length;
        int ans = 1;
        for (int left = 0; left < n; left++) {
            mid: for (int right = left + 1; right < n; right++) {
                for (int i = left + 1; i <= right; i++) {
                    if (height[i - 1] > height[i]) continue mid;
                }
                ans = Math.max(ans, right - left + 1);
            }
        }
        ArrayUtil.reverse(height, 0, n);
        for (int left = 0; left < n; left++) {
            mid: for (int right = left + 1; right < n; right++) {
                for (int i = left + 1; i <= right; i++) {
                    if (height[i - 1] > height[i]) continue mid;
                }
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans;
    }
}
