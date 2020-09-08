package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FDoubleCamelCaseSort {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        String s = in.string();
        int first = 0;
        List<String> all = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                all.add(s.substring(first, i + 1));
                first = i + 1;
                i++;
            }
        }
        all.sort(Comparator.comparing(String::toLowerCase));
        out.ans(String.join("", all)).ln();
    }
}
