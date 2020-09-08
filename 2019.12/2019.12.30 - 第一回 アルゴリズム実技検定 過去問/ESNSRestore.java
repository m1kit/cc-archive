package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ESNSRestore {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), q = in.ints();
        List<HashSet<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(new HashSet<>());
        for (int i = 0; i < q; i++) {
            switch (in.ints()) {
                case 1:
                    int x = in.ints() - 1, y = in.ints() - 1;
                    list.get(x).add(y);
                    break;
                case 2:
                    int z = in.ints() - 1;
                    for (int j = 0; j < n; j++) {
                        if (j != z && list.get(j).contains(z)) list.get(z).add(j);
                    }
                    break;
                case 3:
                    int w = in.ints() - 1;
                    HashSet<Integer> up = (HashSet<Integer>) list.get(w).clone();
                    for (int d : list.get(w)) {
                        up.addAll(list.get(d));
                    }
                    up.remove(w);
                    list.set(w, up);
                    break;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out.print(list.get(i).contains(j) ? 'Y' : 'N');
            }
            out.ln();
        }
    }
}
