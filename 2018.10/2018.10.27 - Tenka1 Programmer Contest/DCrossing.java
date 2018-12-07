package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class DCrossing {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        for (int k = 2; k <= 448; k++) {
            if (k * (k - 1) == 2 * n) {
                out.println(YES);
                out.println(k);
                List<List<Integer>> sets = new ArrayList<>(k);
                for (int i = 0; i < k; i++) {
                    sets.add(new ArrayList<>());
                }

                int m = 0;
                for (int i = 0; i < k; i++) {
                    for (int j = i + 1; j < k; j++) {
                        m++;
                        sets.get(i).add(m);
                        sets.get(j).add(m);
                    }
                }

                for (int i = 0; i < k; i++) {
                    out.print(sets.get(i).size());
                    for (int j = 0; j < sets.get(i).size(); j++) {
                        out.print(' ');
                        out.print(sets.get(i).get(j));
                    }
                    out.println();
                }
                return;
            }
        }
        out.println(NO);
    }
}
