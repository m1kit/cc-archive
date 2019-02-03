package jp.llv.atcoder;

import jp.llv.atcoder.lib.math.IntMath;

import java.util.*;
import java.util.stream.IntStream;

public class MaximizingGCD {

    private final HashSet<Integer> set = new HashSet<>();

    public int maximumGCDPairing(int[] a) {
        int n = a.length;
        int max = IntStream.of(a).max().orElse(-1) * 2;
        Set<Integer> pf = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int t = a[i] + a[j];
                Integer f;
                while ((f = IntMath.getPrimeFactor(t)) != null) {pf.add(f);t /= f;}
                if (t != 1) {
                    pf.add(t);
                }
            }
        }
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        q.addAll(pf);
        //System.out.println(pf);
        int ans = 1;
        HashSet<Integer> t = new HashSet<>(), s = new HashSet<>();
        while (!q.isEmpty()) {
            //ystem.out.println(q);
            t.clear();
            int f = q.poll();
            //System.out.println(f);
            if (f > max) {
                continue;
            }
            for (int e : a) {
                int r = e % f;
                int ro = (f - r) % f;
                if (t.contains(ro)) {
                    t.remove(ro);
                } else {
                    t.add(r);
                }
            }
            if (t.isEmpty()) {
                ans = Math.max(ans, f);
                s.clear();
                if (f * (long) f <= max) {
                    set.add(f * f);
                    //System.out.println("!" + (f * f));
                    s.add(f * f);
                }
                for (int e : q) {
                    if (e * (long) f <= max && !set.contains(e * f)) {
                        //System.out.println("!" + (e * f));
                        set.add(e * f);
                        s.add(e * f);
                    }
                }
                q.addAll(s);
            }
        }
        return ans;
    }
}
