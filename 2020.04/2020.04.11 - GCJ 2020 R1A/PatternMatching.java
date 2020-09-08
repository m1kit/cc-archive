package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PatternMatching {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        out.setCaseLabel(LightWriter.CaseLabel.GCJ);
        int testCases = in.ints();
        loop:
        for (int testCase = 1; testCase <= testCases; testCase++) {
            out.cases(testCase);
            int n = in.ints();
            List<String> tokens = new ArrayList<>();
            String first = "", last = "";
            boolean ok = true;

            for (int i = 0; i < n; i++) {
                char[] s = in.chars();
                if (!ok) continue;

                int m = s.length;
                StringBuilder head = new StringBuilder(), tail = new StringBuilder(), middle = new StringBuilder();
                int begin, end;
                for (begin = 0; begin < m && s[begin] != '*'; begin++) head.append(s[begin]);
                for (end = m - 1; end >= 0 && s[end] != '*'; end--) tail.append(s[end]);
                for (int j = begin; j <= end; j++) if (s[j] != '*') middle.append(s[j]);
                tail.reverse();
                String heads = head.toString(), tails = tail.toString();
                tokens.add(middle.toString());

                if (!startsWith(heads, first) || !endsWith(tails, last)) {
                    ok = false;
                } else {
                    first = max(first, heads);
                    last = max(last, tails);
                }
            }
            //System.out.println(first + " + " + tokens + " + " + last);
            //System.out.println(Arrays.toString("A*C*E".split("\\*")));
            if (ok) {
                out.print(first);
                if (tokens.isEmpty()) tokens.add("A");
                for (String x : tokens) out.print(x);
                out.print(last);
                out.ln().flush();
            } else {
                out.print('*').ln().flush();
            }
        }
    }

    private static String max(String a, String b) {
        return a.length() > b.length() ? a : b;
    }

    private static String min(String a, String b) {
        return a.length() < b.length() ? a : b;
    }

    private static boolean startsWith(String a, String b) {
        return a.length() > b.length() ? a.startsWith(b) : b.startsWith(a);
    }

    private static boolean endsWith(String a, String b) {
        return a.length() > b.length() ? a.endsWith(b) : b.endsWith(a);
    }
}
