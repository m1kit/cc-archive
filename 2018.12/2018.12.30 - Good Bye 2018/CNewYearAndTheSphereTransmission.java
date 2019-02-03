package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;

import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class CNewYearAndTheSphereTransmission {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        long n = in.longs();
        TreeSet<Long> list = new TreeSet<>();
        list.add(1L);
        for (int i = (int) Math.floor(Math.sqrt(n) + 1e-9); i > 0; i--) {
            if (n % i > 0) {
                continue;
            }
            long j = n / i;
            //System.out.println("FOUND i=" + i + " and j=" + j);
            list.add(i * (j * (i - 1) + 2) / 2L);
            list.add(j * (i * (j - 1) + 2) / 2L);
        }
        String ans = list.stream().map(l -> Long.toString(l)).collect(Collectors.joining(" "));
        out.println(ans);
    }
}
