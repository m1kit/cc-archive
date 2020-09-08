package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.string.RollingHash;
import jp.llv.atcoder.lib.util.ArrayUtil;

import java.util.Arrays;

public class EArtist {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        int m = in.ints(), n = in.ints();
        int[] r = new int[n], c = new int[m];
        for (int i = 0; i < m; i++) {
            String s = in.string();
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == '1') {
                    c[i]++;
                    r[j]++;
                }
            }
        }
        long ansr = count(r), ansc = count(c);
        //System.out.println("r=" + ansr + " c=" + ansc);
        out.ansln(ansr * ansc);
    }

    private static long count(int[] a) {
        int n = a.length;
        RollingHash natural = new RollingHash(a);
        ArrayUtil.reverse(a, 0, n);
        RollingHash reverse = new RollingHash(a);
        long ans = 0;
        outer:
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (natural.hash(0, i, j) != reverse.hash(n - i, n, j)) {
                    continue outer;
                }
                if (natural.hash(i, n, j) != reverse.hash(0, n - i, j)) {
                    continue outer;
                }
            }
            ans++;
        }
        return ans;
    }
}
