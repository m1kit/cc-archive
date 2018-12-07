package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class A2540 {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), m = in.ints();
        Zip[] c = new Zip[2001];
        for (int i = 1000; i <= 2000; i++) {
            c[i] = new Zip();
        }

        for (int i = 0; i < m; i++) {
            Line l = new Line(in.ints(), in.ints(), in.ints());
            if (l.l <= 1540) {
                if (c[l.l].lines.containsKey(l.a)) {
                    c[l.l].lines.get(l.a).add(l);
                } else {
                    ArrayList<Line> list = new ArrayList<>();
                    list.add(l);
                    c[l.l].lines.put(l.a, list);
                }
                if (c[l.l].lines.containsKey(l.b)) {
                    c[l.l].lines.get(l.b).add(l);
                } else {
                    ArrayList<Line> list = new ArrayList<>();
                    list.add(l);
                    c[l.l].lines.put(l.b, list);
                }
            }
        }
        long ans = 0;
        for (int i = 1000; i <= 1270; i++) {
            for (int a : c[i].lines.keySet()) {
                if (c[2540 - i].lines.containsKey(a)) {
                    if (i == 1270) {
                        ans += c[i].lines.get(a).size() * (c[2540 - i].lines.get(a).size() - 1) / 2;
                    } else {
                        ans += c[i].lines.get(a).size() * c[2540 - i].lines.get(a).size();
                    }
                }
            }
        }
        out.println(ans);
    }

    private static class Line {
        private final int a;
        private final int b;
        private final int l;

        public Line(int a, int b, int l) {
            this.a = a;
            this.b = b;
            this.l = l;
        }
    }

    private static class Zip {
        private final HashMap<Integer, ArrayList<Line>> lines = new HashMap<>();
    }
}
