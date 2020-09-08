package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class FRemainderProblem {

    private static final int LEN = 500_000;
    private static final int CHA = 1_000;


    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int queries = in.ints();
        int[] array = new int[LEN + 1];
        int[][] cache = new int[CHA + 1][];
        for (int i = 1; i <= CHA; i++) cache[i] = new int[i];
        for (int q = 0; q < queries; q++) {
            int t = in.ints(), x = in.ints(), y = in.ints();
            if (t == 1) {
                array[x] += y;
                for (int i = 1; i <= CHA; i++) cache[i][x % i] += y;
            } else if (x <= CHA) {
                out.ans(cache[x][y]).ln();
            } else {
                long res = 0;
                for (int i = y; i <= LEN; i += x) res += array[i];
                out.ans(res).ln();
            }
        }
    }
}
