package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class D {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;
    private static final int[] MVX = {0, 1, 0, -1, 0, 1, 1, -1, -1};
    private static final int[] MVY = {0, 0, 1, 0, -1, 1, -1, -1, 1};

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int k = in.ints(), n = in.ints();
        int patterns = 1;
        for (int i = 0; i < k; i++) {
            patterns *= 3;
        }
        int[][] v = new int[n][];
        String[] w = new String[n];
        for (int i = 0; i < n; i++) {
            v[i] = in.string().chars().map(c -> c - '1').toArray();
            w[i] = in.string();
        }
        String[] abbr = new String[k];
        int[] length = new int[k];
        outer: for (int i = 0; i < patterns; i++) {
            int t = i;
            for (int j = 0; j < k; j++) {
                length[j] = 1 + t % 3;
                t /= 3;
            }
            Arrays.fill(abbr, null);
            // System.out.println(Arrays.toString(abs));

            for (int j = 0; j < n; j++) {
                if (w[j].length() != Arrays.stream(v[j]).map(d -> length[d]).sum()) {
                    // System.out.println("SUM VALIDATION FAIL");
                    continue outer;
                }
                int index = 0;
                for (int p = 0; p < v[j].length; p++) {
                    String s = w[j].substring(index, index + length[v[j][p]]);
                    if (abbr[v[j][p]] != null && !abbr[v[j][p]].equals(s)) {
                        // System.out.println("EQUAL VALIDATION FAIL: " + s);
                        continue outer;
                    }
                    abbr[v[j][p]] = s;
                    index += length[v[j][p]];
                }
            }
            // System.out.println("VALIDATION THRU");
            break;
        }

        Arrays.stream(abbr).forEach(out::println);
    }
}
