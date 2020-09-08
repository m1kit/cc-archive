package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class D2MagicSquare2 {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int a = in.ints(), b = in.ints(), c = in.ints();
        int s = 3 * c;
        {
            int[][] ans = new int[3][3];
            ans[0][0] = a;
            ans[0][1] = b;
            ans[1][1] = c;
            ans[0][2] = s - a - b;
            ans[2][2] = s - a - c;
            ans[1][2] = s - ans[0][2] - ans[2][2];
            ans[2][1] = s - ans[0][1] - ans[1][1];
            ans[1][0] = s - ans[1][1] - ans[1][2];
            ans[2][0] = s - ans[0][0] - ans[1][0];

            /*{
                int s3 = 0, s4 = 0;
                for (int i = 0; i < 3; i++) {
                    int s1 = 0, s2 = 0;
                    for (int j = 0; j < 3; j++) {
                        s1 += ans[i][j];
                        s2 += ans[j][i];
                    }
                    if (s1 != s || s2 != s) continue outer;
                    s3 += ans[i][i];
                    s4 += ans[i][2 - i];
                }
                if (s3 != s || s4 != s) continue outer;
            }*/

            for (int i = 0; i < 3; i++) {
                out.ans(ans[i]).ln();
            }
        }
    }
}
