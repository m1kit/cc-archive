package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class DXorSum2 {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
           a[i] = in.nextInt();
        }
        int l = 0, r = 0;
        int s = a[0];
        int c = 0;
        while (true) {
            if ((s & a[r]) == 0) {
                s += a[r];
                r++;
            } else {
                s -= a[l];
                l++;
                if (r < l) {
                    r++;
                }
                c += r - l - 1;
            }
        }
        //out.println(c);
    }
}
