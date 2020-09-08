package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FXorShift {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] a = in.ints(n), b = in.ints(n);
        Map<Integer, Integer> freq = new HashMap();
        for (int i = 0; i < n; i++) freq.merge(a[i], 1, Integer::sum);
        HashSet<Integer> witness = new HashSet<>();
        int total = 0;
        for (int x : freq.entrySet().stream().sorted(Map.Entry.comparingByValue()).map(Map.Entry::getKey).collect(Collectors.toList())) {
            if (total + freq.get(x) < 200) {
                witness.add(x);
                total += freq.get(x);
            }
        }
        List<Integer> witnessIndex = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (witness.contains(a[i])) witnessIndex.add(i);
        }


        int[] p = IntStream.range(0, n).toArray();
        ArrayUtil.shuffle(p);

        List<Integer> ans = new ArrayList<>();
        loop:
        for (int i = 0; i < n; i++) {
            int x = a[i] ^ b[0];
            for (int j = 0; j < Math.min(n, 300); j++) {
                if ((a[(p[j] + i) % n] ^ b[p[j]]) != x) continue loop;
            }
            ans.add(i);
        }
        loop:
        for (int i : ans) {
            int x = a[i] ^ b[0];
            if (ans.size() <= 100) {
                for (int j = 0; j < n; j++) {
                    if ((a[(j + i) % n] ^ b[j]) != x) continue loop;
                }
            }
            for (int w : witnessIndex) {
                if ((a[w] ^ b[(w - i + n) % n]) != x) continue loop;
            }
            out.ans(i).ans(x).ln();
        }
    }
}
