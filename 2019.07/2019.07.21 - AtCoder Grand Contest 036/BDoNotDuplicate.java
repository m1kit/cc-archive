package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class BDoNotDuplicate {

    private static final int MAX = 200_001;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long k = in.longs();
        int[] a = in.ints(n);

        /*if (n * k <= 50_000_000) {
            int[] array = new int[MAX];
            int len = 0;
            int[] index = new int[MAX];
            Arrays.fill(index, -1);
            for (long turn = 0; turn < k * n; turn++) {
                int j = (int) (turn % n);
                if (j == 0) System.out.println("=== " + turn / n);
                if (index[a[j]] >= 0 && index[a[j]] < len && array[index[a[j]]] == a[j]) {
                    //System.out.print("Add");
                    len = index[a[j]];
                } else {
                    //System.out.print("Rem");
                    array[len] = a[j];
                    index[a[j]] = len++;
                }
                if (len == 0) System.out.println(a[j] + " Done: " + turn);
                //System.out.println(a[j] + " " + Arrays.toString(Arrays.copyOf(array, len)));
            }
            out.ans(Arrays.copyOf(array, len)).ln();
            return;
        }*/

        int[] firstIndexOf = new int[MAX], lastIndexOf = new int[MAX], correspondsTo = new int[n];
        Arrays.fill(firstIndexOf, -1);
        Arrays.fill(lastIndexOf, -1);
        ArrayUtil.fill(correspondsTo, -1);
        for (int i = 0; i < n; i++) {
            if (firstIndexOf[a[i]] < 0) firstIndexOf[a[i]] = i;
            if (lastIndexOf[a[i]] >= 0) correspondsTo[lastIndexOf[a[i]]] = i;
            lastIndexOf[a[i]] = i;
        }
        for (int i = 0; i < n; i++) {
            if (correspondsTo[i] < 0) correspondsTo[i] = n + firstIndexOf[a[i]];
        }
        int[] next = new int[n], size = new int[n];
        for (int i = 0; i < n; i++) {
            next[i] = (correspondsTo[i] + 1) % n;
            size[i] = correspondsTo[i] - i + 1;
        }
        long totalSize = size[0];
        for (int cur = next[0]; cur != 0; cur = next[cur]) totalSize += size[cur];
        //System.out.println(Arrays.toString(next));
        //System.out.println(Arrays.toString(size));
        long remain = (n * k) % totalSize;
        int cur = 0;
        while (size[cur] <= remain) {
            remain -= size[cur];
            cur = next[cur];
        }

        int[] array = new int[MAX];
        int len = 0;
        int[] index = new int[MAX];
        Arrays.fill(index, -1);
        for (int turn = cur; turn < cur + remain; turn++) {
            int j = turn % n;
            if (index[a[j]] >= 0 && index[a[j]] < len && array[index[a[j]]] == a[j]) {
                len = index[a[j]];
            } else {
                array[len] = a[j];
                index[a[j]] = len++;
            }
        }
        out.ans(Arrays.copyOf(array, len)).ln();
        out.ln();
    }
}
