package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.structure.Vec2l;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Stack;

public class ENegativeDoubling {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        long[] a = in.longs(n);
        long[] dpr = new long[n + 1];
        long[] dpl = new long[n + 1];
        Stack<Vec2l> cap = new Stack<>();
        for (int i = n - 2; i >= 0; i--) {
            long v = a[i + 1];
            long withdraw = 0;
            while (a[i] > v) {
                v *= 4;
                withdraw++;
            }


            long ans = 0;
            while (withdraw > 0 && !cap.isEmpty()) {
                Vec2l c = cap.pop();
                if (c.getY() <= withdraw) {
                    withdraw -= c.getY();
                    ans += c.getY() * (c.getX() - i);
                } else {
                    ans += withdraw * (c.getX() - i);
                    cap.push(new Vec2l(c.getX(), c.getY() - withdraw));
                    withdraw = 0;
                }
            }
            if (withdraw > 0) {
                ans += withdraw * (n - i - 1);
            }

            long w = a[i];
            long store = 0;
            while (w * 4 <= v) {
                w *= 4;
                store++;
            }
            if (store > 0) {
                cap.push(new Vec2l(i, store));
            }

            dpr[i] = dpr[i + 1] + ans;
        }

        cap.clear();
        for (int i = 1; i < n; i++) {
            long v = a[i - 1];

            long withdraw = 0;
            while (a[i] > v) {
                v *= 4;
                withdraw++;
            }


            long ans = 0;
            while (withdraw > 0 && !cap.isEmpty()) {
                Vec2l c = cap.pop();
                if (c.getY() <= withdraw) {
                    withdraw -= c.getY();
                    ans += c.getY() * (i - c.getX());
                } else {
                    ans += withdraw * (i - c.getX());
                    cap.push(new Vec2l(c.getX(), c.getY() - withdraw));
                    withdraw = 0;
                }
            }
            if (withdraw > 0) {
                ans += withdraw * i;
            }

            long w = a[i];
            long store = 0;
            while (w * 4 <= v) {
                w *= 4;
                store++;
            }
            if (store > 0) {
                cap.push(new Vec2l(i, store));
            }

            dpl[i + 1] = dpl[i] + ans;
        }

        long ans = Long.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            ans = Math.min(ans, dpl[i] * 2 + i + dpr[i] * 2);
        }
        out.println(ans);
        //out.println(Arrays.toString(dpr));
        //out.println(Arrays.toString(dpl));
    }
}
