package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class D {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        long a = in.nextLong(), b = in.nextLong();
        out.println(calc(b) - calc(a - 1));
    }

    private long calc(long n) { // 0からnまで調べマス
        char[] cs = Long.toString(n).toCharArray();
        boolean eight = false;
        for (int i = 0; i < cs.length; i++) {
            if (!eight && (cs[i] == '4' || cs[i] == '9')) {
                eight = true;
            } else if (eight) {
                cs[i] = '8';
            }
            if (cs[i] >= '9') {
                cs[i] -= 2;
            } else if (cs[i] >= '4') {
                cs[i]--;
            }
        }
        long wo8 = Long.parseLong(String.valueOf(cs), 8);
        return n - wo8;

    }
}
