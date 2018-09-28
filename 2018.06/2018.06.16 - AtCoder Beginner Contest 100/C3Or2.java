package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class C3Or2 {

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int r = 0;
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int s = a & -a;
            r += log2(s);
        }
        out.println(r);
    }

    static int log2(int n) {
        if (n == 0) {
            return 0;
        }

        int pos = 0;
        if (n >= (1 << 16)) {
            n >>= 16;
            pos += 16;
        }
        if (n >= (1 << 8)) {
            n >>= 8;
            pos += 8;
        }
        if (n >= (1 << 4)) {
            n >>= 4;
            pos += 4;
        }
        if (n >= (1 << 2)) {
            n >>= 2;
            pos += 2;
        }
        if (n >= (1 << 1)) {
            pos += 1;
        }
        return pos;
    }

}
