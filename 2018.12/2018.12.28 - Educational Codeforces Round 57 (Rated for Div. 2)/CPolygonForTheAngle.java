package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.math.IntMath;

import java.io.PrintWriter;
import java.util.Arrays;

public class CPolygonForTheAngle {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int t = in.ints();
        int[] ans = new int[180];
        int c = 0;
        for (int n = 3; n <= 100000; n++) {
            int m = IntMath.lcm(180, n) / n;
            for (int i = 1; i <= n - 2 && i * m < 180; i++) {
                if (ans[i * m] == 0) {
                    ans[i * m] = n;
                    c++;
                }
            }
            //System.out.println("n="+n+" m="+m);
        }
        //System.out.println(c);
        //System.out.println(Arrays.toString(ans));
        for (int i = 0; i < t; i++) {
            int angle = in.ints();
            out.println(ans[angle]);
        }
    }
}
