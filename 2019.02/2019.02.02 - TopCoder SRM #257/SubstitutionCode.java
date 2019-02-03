package jp.llv.atcoder;

import java.util.Arrays;

public class SubstitutionCode {
    public int getValue(String key, String code) {
        int[] val = new int[26];
        Arrays.fill(val, -1);
        val[key.charAt(9) - 'A'] = 0;
        for (int i = 0; i < 9; i++) {
            val[key.charAt(i) - 'A'] = i + 1;
        }
        int ans = 0;
        for (char c : code.toCharArray()) {
            int v = val[c - 'A'];
            if (v >= 0) {
                ans *= 10;
                ans += v;
            }
        }
        return ans;
    }
}
