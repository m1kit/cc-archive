package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CServalAndParenthesisSequence {

    private static final int MOD = (int) 1e9 + 7;
    private static final String NO = ":(";

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        String s = in.string();
        int open = 0, close = 0, wild;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') open++;
            else if (s.charAt(i) == ')') close++;
        }
        if (n % 2 == 1 || open  > n / 2 || close > n / 2) {
            out.ansln(NO);
            return;
        }
        int toOpen = n / 2 - open, toClose = n / 2 - close;
        int depth = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '(') {
                depth++;
                ans.append('(');
            } else if (s.charAt(i) == ')') {
                depth--;
                if (depth <= 0) {
                    out.ansln(NO);
                    return;
                }
                ans.append(')');
            } else if (toOpen > 0) {
                ans.append('(');
                depth++;
                toOpen--;
            } else {
                ans.append(')');
                depth--;
                if (depth == 0) {
                    out.ansln(NO);
                    return;
                }
                toClose--;
            }
        }
        if ((s.charAt(n - 1) != '?' || toClose != 1 || depth != 1) && (s.charAt(n - 1) != ')' || depth != 1 || toClose != 0)) {
            out.ansln(NO);
            return;
        }
        out.ansln(ans.toString() + ')');
    }
}
