package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.Arrays;

public class ESAbATAd {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        // out.setCaseLabel(LightWriter.CaseLabel.NONE);
        out.enableAutoFlush();
        int testCases = in.ints(), b = in.ints();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            out.ans(1).ln().ans(1).ln();
            in.voids();
            in.voids();// sentinel
            Storage storage = new Storage(b);
            int cursor = 0;
            while (cursor * 2 < b) {
                for (int _x = 0; _x < 4 && cursor * 2 < b; _x++) {
                    out.ans(cursor + 1).ln().ans(b - cursor).ln();
                    storage.a[cursor] = in.ints();
                    storage.a[b - cursor - 1] = in.ints();
                    cursor++;
                }
                if (cursor * 2 >= b) break;

                int s = storage.pick(0);
                if (s >= 0) {
                    out.ans(s + 1).ln();
                    if (storage.a[s] != in.ints()) storage.flip();
                } else {
                    out.ans(1).ln();
                    in.voids();
                }

                int t = storage.pick(1);
                if (t >= 0) {
                    out.ans(t + 1).ln();
                    if (storage.a[t] != in.ints()) storage.reverse();
                } else {
                    out.ans(1).ln();
                    in.voids();
                }
            }
            for (int i = 0; i < b; i++) out.print((char) (storage.a[i] + '0'));
            out.ln();
            if ("N".equals(in.string())) return;
        }
    }

    private static class Storage {
        int n;
        int[] a;

        Storage(int n) {
            this.n = n;
            this.a = new int[n];
            Arrays.fill(a, -1);
        }

        void reverse() {
            ArrayUtil.reverse(a, 0, n);
        }

        void flip() {
            for (int i = 0; i < n; i++) {
                if (a[i] >= 0) a[i] ^= 1;
            }
        }

        int pick(int xor) {
            for (int i = 0; i * 2 < n; i++) {
                if (a[i] >= 0 && a[n - i - 1] >= 0 && (a[i] ^ a[n - i - 1]) == xor) return i;
            }
            return -1;
        }
    }
}
