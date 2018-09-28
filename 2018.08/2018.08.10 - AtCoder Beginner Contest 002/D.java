package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class D {

    int[] data = new int[12];
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        for (int i = 0; i < n; i++) {
            data[i] = 1 << i;
        }
        for (int i = 0; i < m; i++) {
            int a = in.nextInt() - 1, b = in.nextInt() - 1;
            data[a] |= 1 << b;
            data[b] |= 1 << a;
        }
        out.println(calc(0, 0));
    }

    public int calc(int choice, int at) {
        if (at >= 12) {
            return 0;
        }
        int ans = calc(choice, at + 1);
        if (((data[at] ^ choice) & choice) == 0) {
            ans = Math.max(ans, 1 + calc(choice | (1 << at), at + 1));
        }
        return ans;
    }

}
