package dev.mikit.atcoder;

import com.sun.xml.internal.ws.model.ParameterImpl;
import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.security.SecureRandom;
import java.util.*;

public class N {
    private static int NUMBERS = 100, BITS = 1000;
    private static int[] HASH = new int[BITS];

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        Random random = new Random("人生がつらい".hashCode());
        for (int i = 0; i < BITS; i++) {
            HASH[i] = random.nextInt(1 << 30);
        }

        switch (in.string()) {
            case "Alice":
            case "Bob":
                int[][] a = new int[NUMBERS][];
                for (int i = 0; i < NUMBERS; i++) {
                    a[i] = in.string().chars().map(c -> c - '0').toArray();
                }
                int[] memo = memo(a);
                for (int i = 0; i < 3000; i++) {
                    out.print((char) (memo[i] + '0'));
                }
                out.ln();
                return;

            case "Charlie":
                int[] x = in.string().chars().map(c -> c - '0').toArray();
                int[] y = in.string().chars().map(c -> c - '0').toArray();
                int[][] q = new int[NUMBERS][];
                for (int i = 0; i < NUMBERS; i++) {
                    q[i] = in.string().chars().map(c -> c - '0').toArray();
                }
                int[][] res = restore(x, y, q);
                for (int i = 0; i < 100; i++) {
                    out.ans(res[i][0] + 1).ans(res[i][1] + 1).ln();
                }
                return;
        }

    }

    private static int hash(int[] num) {
        int hash = 0;
        for (int j = 0; j < BITS; j++) {
            if (num[j] == 1) hash ^= HASH[j];
        }
        return hash;
    }

    private static int[] memo(int[][] num) {
        int offset = 0;
        int[] res = new int[3000];
        for (int i = 0; i < NUMBERS; i++) {
            int hash = hash(num[i]);
            for (int j = 0; j < 30; j++) {
                res[offset++] = hash % 2;
                hash /= 2;
            }
        }
        return res;
    }

    private static int[][] restore(int[] rx, int[] ry, int[][] c) {
        int[][] ans = new int[100][2];
        int[] x = restore(rx), y = restore(ry);

        query:
        for (int query = 0; query < 100; query++) {
            int hash = hash(c[query]);

            for (int i = 0; i < NUMBERS; i++) {
                for (int j = 0; j < NUMBERS; j++) {
                    if ((x[i] ^ y[j]) == hash) {
                        ans[query][0] = i;
                        ans[query][1] = j;
                    }
                }
            }
        }
        return ans;
    }

    private static int[] restore(int[] raw) {
        int offset = 0;
        int[] res = new int[NUMBERS];
        for (int i = 0; i < NUMBERS; i++) {
            for (int j = 0; j < 30; j++) {
                res[i] |= (raw[offset++] << j);
            }
        }
        return res;
    }
}
