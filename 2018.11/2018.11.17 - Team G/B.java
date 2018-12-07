package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.math.counting.Permutation;

import java.io.PrintWriter;
import java.util.stream.IntStream;

public class B {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        String s = in.string();
        int gx = in.ints(), gy = in.ints();
        if (gx == 0 && gy == 0) {
            out.println(YES);
            return;
        }

        int[] p = IntStream.range(0, 4).toArray();
        while (p != null) {
            int x = 0, y = 0;
            for (char c : s.toCharArray()) {
                int d;
                switch (c) {
                    case 'W':
                        d = p[0];
                        break;
                    case 'X':
                        d = p[1];
                        break;
                    case 'Y':
                        d = p[2];
                        break;
                    case 'Z':
                        d = p[3];
                        break;
                        default:
                            throw new RuntimeException();
                }
                switch (d) {
                    case 0:
                        x++;
                        break;
                    case 1:
                        x--;
                        break;
                    case 2:
                        y++;
                        break;
                    case 3:
                        y--;
                        break;
                }
                if (x == gx && y == gy) {
                    out.println(YES);
                    return;
                }
            }
            p = Permutation.nextPermutation(p);
        }
        out.println(NO);
    }
}
