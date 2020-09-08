package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class ATechnogobletOfFire {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        int n = in.ints(), m = in.ints(), k = in.ints();
        int[] p = new int[n], s = new int[n], c = new int[k];
        for (int i = 0; i < n; i++) {
            p[i] = in.ints() - 1;
        }
        for (int i = 0; i < n; i++) {
            s[i] = in.ints() - 1;
        }
        for (int i = 0; i < k; i++) {
            c[i] = in.ints() - 1;
        }

        int[] selected = new int[m];
        Arrays.fill(selected, - 1);

        for (int i = 0; i < n; i++) {
            if (selected[s[i]] == -1 || p[selected[s[i]]] < p[i]) {
                selected[s[i]] = i;
            }
        }
        int ans = 0;
        for (int i = 0; i < k; i++) {
            if (selected[s[c[i]]] != c[i]) {
                ans++;
            }
        }
        out.ansln(ans);

    }
}
