package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CMishkaAndTheLastExam {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        long[] b = in.longs(n / 2);
        long[] a = new long[n / 2];
        long min = 0;
        long max = b[0];
        List<Long> ans = new ArrayList<>();
        for (int i = 0; i < n / 2; i++) {
            a[i] = Math.max(min, b[i] - max);
            //System.out.println("a[i]=" + a[i] + " for min=" + min + " max=" + max);
            min = Math.max(min, a[i]);
            max = Math.min(max, b[i] - a[i]);
            ans.add(a[i]);
        }
        for (int i = n / 2 - 1; i >= 0; i--) {
            ans.add(b[i] - a[i]);
        }
        out.println(ans.stream().map(x -> Long.toString(x)).collect(Collectors.joining(" ")));
    }
}
