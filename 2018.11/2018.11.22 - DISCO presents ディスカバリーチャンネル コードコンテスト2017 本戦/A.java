package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class A {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    private static int[] a = {0, 0, 1, 1};
    private static int[] b = {0, 1, 0, 1};

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int k = in.ints();
        for (int r : new int[]{100, 150}) {
            int ans = 0;
            for (int x = -r; x < r; x += k) {
                outer: for (int y = -r; y < r; y += k) {
                    for (int i = 0; i < 4; i++) {
                        if (((x + k * a[i]) * (x + k * a[i])) + ((y + k * b[i]) * (y + k * b[i])) > (r * r)) {
                            continue outer;
                        }
                    }
                    //System.out.println(x +","+y);
                    ans++;
                }
            }
            out.print(ans + " ");
        }
    }
}
