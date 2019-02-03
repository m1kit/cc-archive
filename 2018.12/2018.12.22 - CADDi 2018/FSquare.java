package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.math.mod.ModMath;
import jp.llv.atcoder.lib.structure.Vec2i;
import jp.llv.atcoder.lib.structure.Vec3i;
import jp.llv.atcoder.lib.util.ArrayUtil;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class FSquare {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = 998244353;

    private static long[][] p;
    private static Map<Vec2i, Integer> map = new HashMap<>();

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), m = in.ints();
        ModMath mod = new ModMath(MOD);
        p = new long[2][n];
        ArrayUtil.fill(p, -1);
        for (int i = 0; i < m; i++) {
            map.put(new Vec2i(in.ints(), in.ints()), in.ints());
        }
    }

    private static long dfs(int i, int c) {
        if (p[c][i] >= 0) {
            return p[c][i];
        } else if (i >= p[0].length) {
            return 1;
        }
        int[] d = new int[2];
        for (int x = 0; x <= 1; x++) {
            for (int y = 0; y <= 1; y++) {
                Vec2i v = new Vec2i(i + x, i + y);
                if (map.containsKey(v)) {
                    d[map.get(v)]++;
                }
            }
        }
        return -1;
    }
}
