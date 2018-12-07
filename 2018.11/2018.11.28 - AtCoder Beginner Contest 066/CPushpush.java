package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class CPushpush {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        int[] a = in.ints(n);

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                list.addFirst(a[i]);
            } else {
                list.addLast(a[i]);
            }
        }
        if (n % 2 == 0) {
            Collections.reverse(list);
        }
        out.println(list.stream().map(Object::toString).collect(Collectors.joining(" ")));
    }
}
