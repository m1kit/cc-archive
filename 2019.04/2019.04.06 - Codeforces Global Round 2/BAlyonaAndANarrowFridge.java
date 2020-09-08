package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.ArrayList;
import java.util.Comparator;

public class BAlyonaAndANarrowFridge {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long h = in.longs();
        long[] a = in.longs(n);

        ArrayList<Long> arr = new ArrayList<>();

        int min = 0, max = n + 1;
        while (max - min > 1) {
            int k = (max + min) / 2;
            for (int i = 0; i < k; i++) {
                arr.add(a[i]);
            }
            arr.sort(Comparator.reverseOrder());
            long height = 0;
            for (int i = 0; i < arr.size(); i += 2) {
                height += arr.get(i);
            }
            //System.out.println("k=" + k + " h=" + height);
            if (height > h) {
                max = k;
            } else {
                min = k;
            }
            arr.clear();
        }
        out.ansln(min);
    }
}
