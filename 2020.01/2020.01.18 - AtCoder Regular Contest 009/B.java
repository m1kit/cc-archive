package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.StringUtil;

import java.util.Comparator;
import java.util.stream.IntStream;

public class B {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        String s = in.nextLine().replace(" ", "");
        IntStream.range(0, in.ints())
                .mapToObj(_x -> in.string())
                .sorted(Comparator.comparing(x -> Integer.parseInt(StringUtil.tr(x, s, "0123456789"))))
                .forEach(x -> out.ans(x).ln());
    }
}
