package dev.mikit.atcoder;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CMisterBAndBoringGame {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int a = in.ints(), b = in.ints(), l = in.ints() - 1, r = in.ints() - 1;

        int min = 26;
        for (char p = 'a'; p <= 'z'; p++) {
            for (char q = (char) ('a' + a); q <= 'z'; q++) {
                StringBuilder rep = new StringBuilder();
                for (int i = 0; i < a; i++) rep.append((char) (i + 'a'));
                for (int i = 0; i < b; i++) rep.append(p);
                outer: for (int i = 0; i < a; i++) {
                    boolean[] f = new boolean[26];
                    for (int j = b; j < a + b + i; j++) {
                        f[rep.charAt(j) - 'a'] = true;
                    }
                    for (int j = 0; j < 26; j++) {
                        if (!f[j]) {
                            rep.append((char) (j + 'a'));
                            continue outer;
                        }
                    }
                }
                for (int i = 0; i < b; i++) rep.append(q);

                boolean[] flag = new boolean[26];
                if (r - l + 1 >= 100_000) {
                    for (int i = 0; i < rep.length(); i++) {
                        flag[rep.charAt(i) - 'a'] = true;
                    }
                } else {
                    for (int i = l; i <= r; i++) {
                        flag[rep.charAt(i % rep.length()) - 'a'] = true;
                    }
                }

                //System.out.println(rep);

                int ans = 0;
                for (int i = 0; i < 26; i++) if (flag[i]) ans++;
                min = Math.min(ans, min);
            }
        }
        out.ans(min).ln();
    }
}
