package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class BCircus {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        String c = in.string(), a = in.string();
        int[] m = new int[4];
        for (int i = 0; i < n; i++) {
            int t = (c.charAt(i) == '1' ? 2 : 0) + (a.charAt(i) == '1' ? 1 : 0);
            m[t]++;
        }

        for (int ac = 0; ac <= m[3]; ac++) {
            for (int jc = 0; jc <= m[2]; jc++) {
                int h = ac + jc;
                if (h > n / 2) {
                    continue;
                }
                int t = m[3] - ac;
                if (t > h) {
                    continue;
                }
                int tja = h - t;//追加アクロバ
                int hja = m[1] - tja;
                if (hja < 0) {
                    continue;
                }

                int tc = (m[3] - ac) + (m[2] - jc) + tja;
                int hc = ac + jc + hja;
                if (Math.abs(tc - hc) > m[0]) {
                    continue;
                }

                int[] count = {n / 2 - hc, hja, jc, ac};
                for (int i = 0; i < n; i++) {
                    int type = (c.charAt(i) == '1' ? 2 : 0) + (a.charAt(i) == '1' ? 1 : 0);
                    if (count[type] > 0) {
                        count[type]--;
                        out.ans(i + 1);
                    }
                }
                out.ln();
                return;
            }
        }
        out.ansln(-1);
    }
}
