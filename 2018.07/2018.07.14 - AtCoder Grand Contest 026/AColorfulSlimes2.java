package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class AColorfulSlimes2 {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int count = 0;
        int last = -1;
        for (int i = 0; i < n; i++) {
            int color = in.nextInt();
            if (color == last) {
                count++;
                last = -1;
            } else {
                last = color;
            }
        }
        out.println(count);
    }
}
