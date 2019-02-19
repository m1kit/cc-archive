package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.geo.Vec2i;

import java.util.*;

public class DRestoreTheTree {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        int n = in.ints();
        int m = in.ints();
        int[] count = new int[n];
        List<List<Integer>> dest = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            dest.add(new ArrayList<>());
        }
        for (int i = 0; i < n + m - 1; i++) {
            int a = in.ints() - 1, b = in.ints() - 1;
            count[b]++;
            dest.get(a).add(b);
        }
        Queue<Integer> q = new LinkedList<>();
        int[] depth = new int[n];
        //Arrays.fill(depth, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if (count[i] == 0) {
                q.offer(i);
                //depth[i] = 0;
            }
        }
        if (q.size() != 1) {
            throw new RuntimeException();
        }
        int[] parents = new int[n];
        while (!q.isEmpty()) {
            int orig = q.poll();
            for (int d : dest.get(orig)) {
                if (depth[d] <= depth[orig]) {
                    depth[d] = depth[orig] + 1;
                    parents[d] = orig + 1;
                    //System.out.println("par="+d+"isnow"+orig);
                }
                if (--count[d] == 0) {
                    q.offer(d);
                }
            }
        }
        //System.out.println(Arrays.toString(parents));
        for (int i = 0; i < n; i++) {
            out.ans(parents[i]).ln();
        }
    }
}
