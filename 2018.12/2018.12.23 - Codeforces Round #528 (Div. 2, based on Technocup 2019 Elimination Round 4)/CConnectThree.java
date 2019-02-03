package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.math.IntMath;
import jp.llv.atcoder.lib.structure.vector.Vec2i;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

public class CConnectThree {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int[] x = new int[3];
        int[] y = new int[3];
        in.ints(x, y);
        int xw = IntMath.max(x) - IntMath.min(x) + 1;
        int yw = IntMath.max(y) - IntMath.min(y) + 1;
        out.println(xw + yw - 1);


        Vec2i[] vs = new Vec2i[3];
        for (int i = 0; i < 3; i++) {
            vs[i] = new Vec2i(x[i], y[i]);
        }
        Arrays.sort(vs, Comparator.comparing(v -> v.y));
        int ay = vs[1].y;
        for (int i = IntMath.min(x); i <= IntMath.max(x); i++) {
            out.print(i);
            out.print(' ');
            out.println(ay);
        }

        for (int i = Math.min(ay, vs[0].y); i <= Math.max(ay, vs[0].y); i++) {
            if (i == ay) {
                continue;
            }
            out.print(vs[0].x);
            out.print(' ');
            out.println(i);
        }

        for (int i = Math.min(ay, vs[2].y); i <= Math.max(ay, vs[2].y); i++) {
            if (i == ay) {
                continue;
            }
            out.print(vs[2].x);
            out.print(' ');
            out.println(i);
        }
    }
}
