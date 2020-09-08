package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.*;

public class L {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        Container[] containers = new Container[n];
        for (int i = 0; i < n; i++)  containers[i] = new Container(in.ints(in.ints()));
        TreeSet<Container> t1 = new TreeSet<>(Comparator.comparing(Container::getOne));
        TreeSet<Container> t2 = new TreeSet<>(Comparator.comparing(Container::getTwo));
        t1.addAll(Arrays.asList(containers));
        t2.addAll(Arrays.asList(containers));
        int m = in.ints();
        for (int i = 0; i < m; i++) {
            if (in.ints() == 1) {
                Container container = t1.pollFirst();
                t2.remove(container);
                out.ans(container.takeOne()).ln();
                t1.add(container);
                t2.add(container);
            } else {
                Container container = t2.pollFirst();
                t1.remove(container);
                out.ans(container.takeTwo()).ln();
                t1.add(container);
                t2.add(container);
            }
        }
    }

    private static class Container {
        private final LinkedList<Integer> list = new LinkedList<>();

        Container(int[] a) {
            for (int x : a) list.add(x);
        }

        int getOne() {
            if (list.isEmpty()) return Integer.MAX_VALUE;
            return -list.getFirst();
        }

        int getTwo() {
            if (list.size() < 2) return getOne();
            return -Math.max(list.getFirst(), list.get(1));
        }

        int takeOne() {
            return list.removeFirst();
        }

        int takeTwo() {
            if (list.size() < 2 || list.getFirst() >= list.get(1)) return list.removeFirst();
            else return list.remove(1);
        }
    }
}
