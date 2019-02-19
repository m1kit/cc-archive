package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

import java.util.PriorityQueue;

public class ASashaAndHisTrip {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        //Debug.enable("src");

        //int n = in.ints(), v = in.ints();
        for (int x = 2; x < 100; x++) {
            for (int v = 1; v < 100; v++) {
                int n = x;

                int r = 1;
                long ans = 0;
                for (int i = 1; i < n; i++) {
                    r--;
                    int d = r < n - i ? Math.min(n - i, v - r) : 0;
                    //System.out.println("@"+i+" dist="+(n - i ) + " cf="+r +" buy="+d);
                    ans += i * d;
                    r += d;
                }

                long tans = 0;
                if ((n - 1) <= v) {
                    tans = n - 1;
                } else {
                    tans = v;
                    int l = n - (n - v - 1);
                    for (int i = l, ii = 2; i < n; i++, ii++) {
                        tans+=ii;
                    }
                }

                if (tans != ans) {
                    System.out.println("HACKED: n =" + x + " v=" + v);
                    System.out.println("ANS="+ans+ " ACT="+tans);
                    if ((x == 4 && v == 2) || (x == 7 && v == 6)) {
                        System.out.println("[WI!!]");
                        return;
                    }
                }
            }
        }
        //out.ans(ans).ln();
    }
}
