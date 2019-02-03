package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;

import java.util.ArrayList;
import java.util.List;

public class CInsertingX {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        String s = in.string();
        String r = new StringBuilder(s).reverse().toString();
        StringBuilder rw = new StringBuilder(), sw = new StringBuilder();
        int sx = 0, rx = 0;
        List<Integer> sxs = new ArrayList<>(), rxs = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'x') {
                sx++;
            } else {
                sxs.add(sx);
                sx = 0;
                sw.append(s.charAt(i));
            }
            if (r.charAt(i) == 'x') {
                rx++;
            } else {
                rxs.add(rx);
                rx = 0;
                rw.append(r.charAt(i));
            }
        }
        if (!sw.toString().equals(rw.toString())) {
            out.ans(-1).ln();
            return;
        }
        sxs.add(sx);
        rxs.add(rx);
        long ans = 0;
        for (int i = 0; i < sxs.size(); i++) {
            ans += Math.abs(sxs.get(i) - rxs.get(i));
        }
        out.ans(ans / 2).ln();
    }
}
