package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CPalindromicMatrix {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int h = in.ints(), w = in.ints();
        int[] cnt = new int[26];
        for (int i = 0; i < h; i++) {
            String s = in.string();
            for (int j = 0; j < w; j++) {
                cnt[s.charAt(j) - 'a']++;
            }
        }
        int c1 = 0, c2 = 0, c4 = 0;
        for (int i = 0; i < 26; i++) {
            while (cnt[i] >= 4) {
                cnt[i] -= 4;
                c4++;
            }
            c2 += cnt[i] / 2;
            c1 += cnt[i] % 2;
        }

        {
            int c4r = (h / 2) * (w / 2);
            if (c4 < c4r) {
                out.noln();
                return;
            }
            c4 -= c4r;
            c2 += c4 * 2;
        }

        {
            int c2r = 0;
            if (h % 2 == 1) c2r += w / 2;
            if (w % 2 == 1) c2r += h / 2;
            if (c2 < c2r) {
                out.noln();
                return;
            }
            c2 -= c2r;
            c1 += c2 * 2;
        }

        out.ans(c1 == (h % 2) * (w % 2)).ln();
    }
}
