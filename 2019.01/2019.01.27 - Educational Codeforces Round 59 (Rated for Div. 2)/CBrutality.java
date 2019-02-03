package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CBrutality {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        int n = in.ints(), k = in.ints();
        int[] a = in.ints(n);
        String s = in.string();
        char last = '@';
        List<Integer> list = new ArrayList<>();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != last) {
                last = s.charAt(i);
                list.sort(Comparator.reverseOrder());
                for (int j = 0; j < Math.min(k, list.size()); j++) {
                    ans += list.get(j);
                }
                list.clear();
            }
            list.add(a[i]);
        }
        list.sort(Comparator.reverseOrder());
        for (int j = 0; j < Math.min(k, list.size()); j++) {
            ans += list.get(j);
        }
        out.ans(ans).ln();
    }
}
