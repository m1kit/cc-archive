package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.structure.Vec2i;
import jp.llv.atcoder.lib.structure.Vec2l;
import jp.llv.atcoder.lib.util.function.BiLongFunction;

import java.io.PrintWriter;

public class BCheckpoints {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), m = in.ints();
        Vec2l[] s = new Vec2l[n];
        in.objs(s, (BiLongFunction<Vec2l>) Vec2l::new);
        Vec2l[] c = new Vec2l[m];
        in.objs(c, (BiLongFunction<Vec2l>) Vec2l::new);
        for (int i = 0; i < n; i++) {
            long min = Long.MAX_VALUE;
            int mi = -1;
            for (int j = 0; j < m; j++) {
                long d = Math.abs(s[i].getX() - c[j].getX()) + Math.abs(s[i].getY() - c[j].getY());
                if (d < min) {
                    mi = j;
                    min = d;
                }
            }
            out.println(mi + 1);
        }
    }
}
