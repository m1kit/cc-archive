package jp.llv.atcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class DAtCoderExpress2 {

    private static int n;
    private static int m;
    private static int q;
    private static int[][] trains;
    private static int[][] ans;


    public void solve(int testNumber, Scanner in, PrintWriter out) {
        /* 1. PREPARE DATA STRUCTURE */
        n = in.nextInt();
        m = in.nextInt();
        q = in.nextInt();
        trains = new int[n + 1][n + 1]; //[l]から[r]まで走る電車の数
        ans = new int[n + 1][n + 1]; //[l]と[r]に含まれる電車の数
        for (int[] a : ans) {
            Arrays.fill(a, -1);
        }

        /* 2. INPUT */
        for (int i = 0; i < m; i++) {
            trains[in.nextInt()][in.nextInt()]++;
        }

        /* 3. OUTPUT */
        for (int i = 0; i < q; i++) {
            out.println(calc(in.nextInt(), in.nextInt()));
        }
    }

    private int calc(int l, int r) {
        if (ans[l][r] >= 0) {
            return ans[l][r];
        }
        if (r < l) {
            return ans[l][r] = 0;
        }
        if (l == r) {
            return ans[l][r] = trains[l][r];
        }
        return ans[l][r] = (calc(l, r - 1) + calc(l + 1, r) - calc(l + 1, r - 1) + trains[l][r]);
    }
}
