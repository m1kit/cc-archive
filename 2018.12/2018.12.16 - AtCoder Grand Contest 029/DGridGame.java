package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.*;

public class DGridGame {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int h = in.ints(), w = in.ints(), n = in.ints();
        Map<Integer, List<Integer>> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = in.ints(), y = in.ints();
            if (y <= x) {
                if (!m.containsKey(y)) {
                    m.put(y, new ArrayList<>());
                }
                m.get(y).add(x);
            }
        }
        for (List<Integer> e : m.values()) {
            e.sort(Comparator.naturalOrder());
        }
        int ans = h;
        int minx = 1;
        for (int i = 1; i <= w; i++) {
            //System.out.println("FOR " + i + " minx " + minx);
            int rx = h;
            if (m.containsKey(i)) {
                for (Integer d : m.get(i)) {
                    if (d == minx) {
                        throw new RuntimeException();
                    } else if (d > minx) {
                        rx = d - 1;
                        //System.out.println("FOUND " + d);
                        if (minx == d + 1) {
                            ans = Math.min(ans, rx - 1);
                        } else {
                            ans = Math.min(ans, rx);
                        }
                        break;
                    }
                }
            }
            if (minx == rx) {
                break;
            }
            minx++;
            if (m.containsKey(i + 1)) {
                while (m.get(i + 1).contains(minx)) {
                    minx++;
                }
            }
            if (minx > rx) {
                break;
            }
        }
        out.println(ans);
    }
}
