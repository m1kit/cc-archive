package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class BPINCodes {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = in.ints();
            String[] pins = in.string(n);
            HashSet<String> set = new HashSet<>(Arrays.asList(pins)), done = new HashSet<>();
            out.ans(n - set.size()).ln();
            for (int i = 0; i < n; i++) {
                if (!done.contains(pins[i])) {
                    done.add(pins[i]);
                    out.ans(pins[i]).ln();
                } else {
                    char[] s = pins[i].toCharArray();
                    while (set.contains(String.valueOf(s)) || done.contains(String.valueOf(s))) {
                        s[0] = (char) ((s[0] - '0' + 1) % 10 + '0');
                    }
                    out.ans(String.valueOf(s)).ln();
                    done.add(String.valueOf(s));
                }
            }
        }
    }
}
