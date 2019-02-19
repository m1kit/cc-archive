package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.geo.GeoWalker;

import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

public class BMinesweeper {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int h = in.ints(), w = in.ints();
        String[] s = in.string(h);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (s[i].charAt(j) == '#') {
                    out.print('#');
                    continue;
                }
                AtomicInteger ans = new AtomicInteger();
                GeoWalker.forEach8i(j, i, (x, y) -> {
                    if (0 <= x && x < w && 0 <= y && y < h && s[y].charAt(x) == '#') {
                        ans.getAndIncrement();
                    }
                });
                out.print(ans);
            }
            out.println();
        }
    }
}
