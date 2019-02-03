package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;

public class EPolycarpsNewJob {

    private static final String YES = "YES";
    private static final String NO = "NO";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        int min = 0, max = 0;
        for (int i = 0; i < n; i++) {
            char c = in.string().charAt(0);
            switch (c) {
                case '+': {
                    int x = in.ints(), y = in.ints();
                    if (x > y) {
                        int t = x;
                        x = y;
                        y = t;
                    }
                    min = Math.max(min, x);
                    max = Math.max(max, y);
                    break;
                }
                case '?': {
                    int x = in.ints(), y = in.ints();
                    if (x > y) {
                        int t = x;
                        x = y;
                        y = t;
                    }
                    if (min <= x && max <= y) {
                        out.ans(YES).ln();
                    } else {
                        out.ans(NO).ln();
                    }
                    break;
                }
            }
        }
    }
}
