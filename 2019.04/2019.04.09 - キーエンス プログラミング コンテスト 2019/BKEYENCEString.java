package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BKEYENCEString {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        String s = in.string();
        out.ans(
                s.matches("^.*keyence$") ||
                        s.matches("^k.*eyence$") ||
                        s.matches("^key.*ence$") ||
                        s.matches("^keye.*nce$") ||
                        s.matches("^keyen.*ce$") ||
                        s.matches("^keyenc.*e$") ||
                        s.matches("^keyence.*$") ||
                        s.matches("^ke.*yence$")
        ).ln();
    }
}
