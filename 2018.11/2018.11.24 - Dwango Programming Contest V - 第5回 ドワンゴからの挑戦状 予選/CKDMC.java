package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;

import java.io.PrintWriter;
import java.util.Arrays;

public class CKDMC {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    static int[] mc;
    static int[] cc;
    static String s;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        mc = new int[n + 1];
        cc = new int[n + 1];
        s = in.string();
        for (int i = 0; i < n; i++) {
            mc[i + 1] = mc[i] + (s.charAt(i) == 'M' ? 1 : 0);
            cc[i + 1] = cc[i] + (s.charAt(i) == 'C' ? 1 : 0);
        }

        //System.out.println(Arrays.toString(mc));


        int q = in.ints();
        for (int i = 0; i < q; i++) {
            int k = in.ints();
            long ans = 0;
            long c = 0;
            long m = 0;
            long s = 0;
            for (int l = -k; l < n; l++) {
                int r = l + k - 1;
                switch (charat(r)) {
                    case 'M':
                        m++;
                        break;
                    case 'C':
                        c++;
                        s += m;
                        break;
                }
                switch (charat(l)) {
                    case 'D':
                        ans += s;
                        break;
                    case 'M':
                        s -= c;
                        m--;
                        break;
                    case 'C':
                        c--;
                        break;
                }
            }
            if (s > 0) {
                throw new RuntimeException();
            }
            out.println(ans);
        }
    }

    private char charat(int i) {
        if (i < 0 || s.length() <= i) {
            return '-';
        } else {
            return s.charAt(i);
        }
    }

    private int ms(int l, int r) {
        return mc[Math.min(mc.length - 1, r + 1)] - mc[Math.max(0, l)];
    }

    private int cs(int l, int r) {
        return cc[Math.min(mc.length - 1, r + 1)] - mc[Math.max(0, l)];
    }
}
