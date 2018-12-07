package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

public class CID {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        int m = in.ints();
        City[] c = new City[m];
        City[] s = new City[m];

        for (int i = 0; i < m; i++) {
            s[i] = c[i] = new City(i, in.ints(), in.ints());
        }
        Arrays.sort(s, Comparator.comparing(q -> q.year));
        int[] b = new int[n + 1];
        for (City q : s) {
            b[q.pref]++;
            q.app = b[q.pref];
        }
        for (City q : c) {
            out.println(String.format("%06d", q.pref) + String.format("%06d", q.app));
        }
    }

    private static class City {
        int index;
        int year;
        int pref;
        int app = -1;

        public City(int index, int pref, int year) {
            this.index = index;
            this.year = year;
            this.pref = pref;
        }
    }
}
