package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.List;

public class B1CharacterSwapEasyVersion {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int testCases = in.ints();
        test:
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = in.ints();
            char[] s = in.string().toCharArray(), t = in.string().toCharArray();
            int[] cnt = new int[26];
            for (int i = 0; i < n; i++) {
                cnt[s[i] - 'a']++;
                cnt[t[i] - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (cnt[i] % 2 == 1) {
                    out.noln();
                    continue test;
                }
            }
            int ops = 0;
            for (int i = 0; i < n - 1; i++) {
                if (s[i] == t[i]) continue;

                int target = -1;
                for (int j = i + 1; j < n; j++) {
                    if (s[j] == s[i] && s[j] != t[j]) {
                        target = j;
                        break;
                    }
                }
                if (target >= 0) {
                    char tmp = t[i];
                    t[i] = s[target];
                    s[target] = tmp;
                    ops++;
                    continue;
                }
                for (int j = i + 1; j < n; j++) {
                    if (t[j] == s[i] && s[j] != t[j]) {
                        target = j;
                        break;
                    }
                }
                if (target == -1) throw new RuntimeException(s[i] + "");
                ops += 2;
                char tmp = s[i + 1];
                s[i + 1] = t[i];
                t[i] = t[target];
                t[target] = tmp;
            }
            out.ans(ops <= 1).ln();
        }
    }
}
