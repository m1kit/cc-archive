package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class B1CatPartyEasyEdition {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] a = in.ints(n);
        int ans = 1;
        int[] cnt = new int[100_001];
        HashMap<Integer, Integer> sizes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (cnt[a[i]] != 0) {
                if (!sizes.containsKey(cnt[a[i]])) {
                    throw new RuntimeException();
                } else if (sizes.get(cnt[a[i]]) == 1) {
                    sizes.remove(cnt[a[i]]);
                } else {
                    sizes.put(cnt[a[i]], sizes.get(cnt[a[i]]) - 1);
                }
            }

            cnt[a[i]]++;
            sizes.merge(cnt[a[i]], 1, Integer::sum);

            if (sizes.size() == 1) {
                Map.Entry<Integer, Integer> ent = sizes.entrySet().iterator().next();
                if (ent.getKey() == 1 || ent.getValue() == 1) {
                    ans = i + 1;
                }
            } else if (sizes.size() == 2) {
                Iterator<Map.Entry<Integer, Integer>> it = sizes.entrySet().iterator();
                Map.Entry<Integer, Integer> x = it.next(), y = it.next();
                if (x.getKey() > y.getKey()) {
                    Map.Entry<Integer, Integer> tmp = x;
                    x = y;
                    y = tmp;
                }
                if (y.getKey() - x.getKey() == 1 && y.getValue() == 1) {
                    ans = i + 1;
                } else if ((x.getKey() == 1 && x.getValue() == 1) || (y.getKey() == 1 && y.getValue() == 1)) {
                    ans = i + 1;
                }
            }
        }

        int val = 0;
        for (Map.Entry<Integer, Integer> ent : sizes.entrySet()) {
            val += ent.getKey() * ent.getValue();
        }
        if (val != n) throw new RuntimeException();

        out.ans(ans).ln();
    }
}
