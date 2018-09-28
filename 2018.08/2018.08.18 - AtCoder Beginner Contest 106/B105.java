package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class B105 {

    private static final int[] SPECIAL_NUMBERS = {105, 135, 165, 189, 195};

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int  n = in.nextInt();
        int ans = 0;
        for (int s : SPECIAL_NUMBERS) {
            if (s <= n) {
                ans++;
            }
        }
        out.println(ans);
    }
}
