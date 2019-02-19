package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.geo.GeoWalker;
import jp.llv.atcoder.lib.structure.IntPair;
import jp.llv.atcoder.lib.util.ArrayUtil;

import java.io.PrintWriter;
import java.util.*;

public class CItoCampus {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    private static int h, w;
    private static int[][] wall;
    private static int[][] dist;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        h = in.ints();
        w = in.ints();
        int range = in.ints();
        wall = new int[h][w];

        IntPair start = null, goal = null;
        Set<IntPair> pigs = new HashSet<>();
        for (int y = 0; y < h; y++) {
            String s = in.string();
            for (int x = 0; x < w; x++) {
                if (s.charAt(x) == '#') {
                    wall[y][x] = Integer.MAX_VALUE;
                } else if (s.charAt(x) == '@') {
                    try {
                        pigs.add(new IntPair(x, y));
                    } catch (ClassCastException ex) {
                        return;
                    }
                } else if (s.charAt(x) == 'S') {
                    start = new IntPair(x, y);
                } else if (s.charAt(x) == 'G') {
                    goal = new IntPair(x, y);
                }
            }
        }

        if (start == null || goal == null) {
            throw new RuntimeException();
        }

        for (IntPair p : pigs) {
            Queue<IntPair> r = new LinkedList<>();
            wall[p.value][p.key] = range + 1;
            r.add(p);
            while (!r.isEmpty()) {
                IntPair q = r.poll();
                GeoWalker.forEach4i(q.key, q.value, (nx, ny) -> {
                    if (wall[ny][nx] < wall[q.value][q.key] - 1) {
                        wall[ny][nx] = wall[q.value][q.key] - 1;
                        r.add(new IntPair(nx, ny));
                    }
                });
            }
        }

        dist = new int[h][w];
        ArrayUtil.fill(dist, Integer.MAX_VALUE);
        dist[start.value][start.key] = 0;
        Queue<IntPair> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            IntPair p = q.poll();
            GeoWalker.forEach4i(p.key, p.value, (nx, ny) -> {
                if (wall[ny][nx] == 0 && dist[ny][nx] > 1 + dist[p.value][p.key]) {
                    dist[ny][nx] = dist[p.value][p.key] + 1;
                    q.add(new IntPair(nx, ny));
                }
            });
        }
        out.println(dist[goal.value][goal.key] == Integer.MAX_VALUE ? -1 : dist[goal.value][goal.key]);
    }
}
