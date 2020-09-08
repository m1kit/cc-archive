package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BLRUDGame {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        int h = in.ints(), w = in.ints(), n = in.ints();
        int sr = in.ints() - 1, sc = in.ints() - 1;
        String s = in.string(), t = in.string();

        {
            int c = sc;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'L') c--;
                if (c == -1) {
                    out.noln();
                    return;
                }
                if (t.charAt(i) == 'R' && c + 1 < w) c++;
            }

            c = sc;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'R') c++;
                if (c == w) {
                    out.noln();
                    return;
                }
                if (t.charAt(i) == 'L' && c > 0) c--;
            }
        }

        {
            int r = sr;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'U') r--;
                if (r == -1) {
                    out.noln();
                    return;
                }
                if (t.charAt(i) == 'D' && r + 1 < h) r++;
            }

            r = sr;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'D') r++;
                if (r == h) {
                    out.noln();
                    return;
                }
                if (t.charAt(i) == 'U' && r > 0) r--;
            }
        }

        out.yesln();
    }
}
