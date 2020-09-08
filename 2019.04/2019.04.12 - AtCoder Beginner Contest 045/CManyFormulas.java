package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CManyFormulas {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        String s = in.string();
        int n = s.length() - 1;
        long ans = 0;
        for (int i = 0; i < (1 << n); i++) {
            long num = s.charAt(0) - '0';
            long sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) == 0) {
                    num *= 10;
                    num += s.charAt(j + 1) - '0';
                } else {
                    sum += num;
                    num = s.charAt(j + 1) - '0';
                }
            }
            sum += num;
            //System.out.println(Integer.toBinaryString(i) + ":" + sum);
            ans += sum;
        }
        out.ansln(ans);
    }
}
