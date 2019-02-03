package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.math.geo.GeoWalker;
import jp.llv.atcoder.lib.structure.vector.Vec2i;
import jp.llv.atcoder.lib.structure.vector.Vec2l;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CAlternatingPath {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    private static int h;
    private static int w;
    private static String[] s;
    private static int[][] dp;

    private static final Vec2l ZERO = new Vec2l(0, 0);

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        h = in.ints();
        w = in.ints();
        s = in.string(h);
        dp = new int[h][w];

        long ans = 0;
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (dp[y][x] > 0) {
                    continue;
                }
                Vec2l r = dfs(x, y);
                //System.out.println("@@x="+x+" y="+y + " r="+r);
                ans += r.x * (long) r.y;
            }
        }
        //Arrays.stream(dp).map(Arrays::toString).forEach(System.out::println);
        out.ans(ans).ln();
    }

    private static Vec2l dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= w || y >= h) {
            return ZERO;
        } else if (dp[y][x] > 0) {
            if (dp[y][x] > 1) {
                return ZERO;
            }
            /*GeoWalker.forEach4i(x, y, (nx, ny) -> {
                if (f(x, y) == f(nx, ny) && dp[ny][nx] == 0) {
                    Arrays.stream(dp).map(Arrays::toString).forEach(System.out::println);
                    throw new RuntimeException("x=" + x + " y=" + y + " nx=" + nx + " ny=" + ny);
                }
            });*/
            return ZERO;
        }
        //System.out.println("x="+x+" y="+y);
        dp[y][x] = 1;
        //Arrays.stream(dp).map(Arrays::toString).forEach(System.out::println);
        Vec2l r;
        if (s[y].charAt(x) == '.') {
            r = new Vec2l(1, 0);
        } else {
            r = new Vec2l(0, 1);
        }

        List<Vec2l> res = new ArrayList<>();
        GeoWalker.forEach4i(x, y, (nx, ny) -> {
            if (f(x, y) == f(nx, ny)) {
                res.add(dfs(nx, ny));
            }
        });
        for (Vec2l rep : res) {
            r = r.add(rep);
        }
        dp[y][x] = 2;
        return r;
    }

    private static int f(int x, int y) {
        if (x < 0 || y < 0 || x >= w || y >= h) {
            return -1;
        }
        return (s[y].charAt(x) == '.') == ((x + y) % 2 == 0) ? 0 : 1;
    }
}
