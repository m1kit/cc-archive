package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.StringUtil;

public class B {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        out.ans(StringUtil.tr(in.nextLine().toLowerCase(), "zrbcdwtjfqlvsxpmhkng", "00112233445566778899")
                .replaceAll("[^0-9 ]", "").trim().replaceAll(" {2,}", " ")).ln();
    }
}
