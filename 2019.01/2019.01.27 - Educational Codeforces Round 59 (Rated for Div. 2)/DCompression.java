package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.stream.Stream;

public class DCompression {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        int n = in.ints();
        List<Integer> divisors = new ArrayList<>(60);
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }
        BitSet[] adj = new BitSet[n];
        for (int i = 1; i < n; i++) {
            BitSet bit = new BitSet(divisors.size());
            for (int j = 0; j < divisors.size(); j++) {
                if (i % divisors.get(j) == 0) {
                    bit.set(j);
                }
            }
            adj[i] = bit;
        }
        BitSet ans = new BitSet(divisors.size());
        ans.set(0, divisors.size());

        //System.out.println(divisors);
        //System.out.println(Arrays.toString(adj));

        String[] con = in.string(n);
        boolean[][] m = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 4; j++) {
                char code = con[i].charAt(j);
                int num;
                if ('0' <= code && code <= '9') {
                    num = code - '0';
                } else {
                    num = code - 'A' + 10;
                }
                for (int k = 0; k < 4; k++) {
                    int c = j * 4 + k;
                    m[i][c] = ((num >> (3 - k)) & 1) == 1;
                }
            }
        }

        //Stream.of(m).map(Arrays::toString).forEach(System.out::println);

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (m[i][j - 1] != m[i][j]) {
                    ans.and(adj[j]);
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (m[i - 1][j] != m[i][j]) {
                    ans.and(adj[i]);
                }
            }
        }

        for (int i = divisors.size() - 1; i >= 0; i--) {
            if (ans.get(i)) {
                out.ans(divisors.get(i)).ln();
                return;
            }
        }
        throw new RuntimeException();
    }
}
