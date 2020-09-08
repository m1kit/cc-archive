package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AInformationSearch {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints();
        int[] a = in.ints(n), b = in.ints(m);
        List<Integer> and = new ArrayList<>();
        List<Integer> or = new ArrayList<>();
        {
            int c = 0, i = 0;
            for (; i < n; i++) {
                while (c < m && b[c] < a[i]) {
                    or.add(b[c]);
                    c++;
                }
                if (c == m) {
                    break;
                }
                or.add(a[i]);
                if (b[c] == a[i]) {
                    and.add(a[i]);
                    c++;
                }
            }

            for (; i < n; i++) {
                or.add(a[i]);
            }
            for (; c < m; c++) {
                or.add(b[c]);
            }
        }
        out.ans(and.size()).ans(or.size()).ln();
        for (int i = 0; i < and.size(); i++) {
            out.ans(and.get(i)).ln();
        }
        for (int i = 0; i < or.size(); i++) {
            out.ans(or.get(i)).ln();
        }
    }
}
