package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.*;

public class FAirSafety {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        Map<Integer, List<P>> lr = new HashMap<>();
        Map<Integer, List<P>> du = new HashMap<>();
        Map<Integer, List<P>> ul = new HashMap<>();
        Map<Integer, List<P>> ur = new HashMap<>();
        Map<Integer, List<P>> dl = new HashMap<>();
        Map<Integer, List<P>> dr = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = in.ints(), y = in.ints();
            char c = in.chr();
            if (c == 'D') {
                du.computeIfAbsent(x, k -> new ArrayList<>()).add(new P(y, -1));
                dl.computeIfAbsent(x + y, k -> new ArrayList<>()).add(new P(x, 1));
                dr.computeIfAbsent(x - y, k -> new ArrayList<>()).add(new P(x, -1));
            }
            if (c == 'U') {
                du.computeIfAbsent(x, k -> new ArrayList<>()).add(new P(y, 1));
                ul.computeIfAbsent(x - y, k -> new ArrayList<>()).add(new P(x, 1));
                ur.computeIfAbsent(x + y, k -> new ArrayList<>()).add(new P(x, -1));
            }
            if (c == 'L') {
                lr.computeIfAbsent(y, k -> new ArrayList<>()).add(new P(x, -1));
                dl.computeIfAbsent(x + y, k -> new ArrayList<>()).add(new P(x, -1));
                ul.computeIfAbsent(x - y, k -> new ArrayList<>()).add(new P(x, -1));
            }
            if (c == 'R') {
                lr.computeIfAbsent(y, k -> new ArrayList<>()).add(new P(x, 1));
                dr.computeIfAbsent(x - y, k -> new ArrayList<>()).add(new P(x, 1));
                ur.computeIfAbsent(x + y, k -> new ArrayList<>()).add(new P(x, 1));
            }
        }

        long ans = Integer.MAX_VALUE;
        ans = Math.min(ans, 5 * lr.values().stream().map(FAirSafety::solve).mapToLong(x -> x).min().orElse(Integer.MAX_VALUE));
        ans = Math.min(ans, 5 * du.values().stream().map(FAirSafety::solve).mapToLong(x -> x).min().orElse(Integer.MAX_VALUE));
        ans = Math.min(ans, 10 * dr.values().stream().map(FAirSafety::solve).mapToLong(x -> x).min().orElse(Integer.MAX_VALUE));
        ans = Math.min(ans, 10 * dl.values().stream().map(FAirSafety::solve).mapToLong(x -> x).min().orElse(Integer.MAX_VALUE));
        ans = Math.min(ans, 10 * ur.values().stream().map(FAirSafety::solve).mapToLong(x -> x).min().orElse(Integer.MAX_VALUE));
        ans = Math.min(ans, 10 * ul.values().stream().map(FAirSafety::solve).mapToLong(x -> x).min().orElse(Integer.MAX_VALUE));


        if (ans < 0) throw new RuntimeException();
        if (ans >= Integer.MAX_VALUE) out.ans("SAFE").ln();
        else out.ans(ans).ln();
    }

    private static long solve(List<P> li) {
        long ans = Integer.MAX_VALUE;
        li.sort(Comparator.comparing(p -> p.x));
        for (int i = 1; i < li.size(); i++) {
            if (li.get(i - 1).d == 1 && li.get(i).d == -1) {
                ans = Math.min(ans, li.get(i).x - li.get(i - 1).x);
            }
        }
        return ans;
    }

    private static class P {
        int x, d;

        P(int x, int d) {
            this.x = x;
            this.d = d;
        }
    }
}
