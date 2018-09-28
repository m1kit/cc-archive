package jp.llv.atcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class DNonDecreasing {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        out.println(2 * n - 1);

        int max = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            if (Math.abs(max) < Math.abs(a)) {
                max = a;
                index = i;
            }
        }
        for (int i = 0; i < n; i++) {
            out.print(index + 1);
            out.print(' ');
            out.println(i + 1);
        }

        if (max < 0) {
            for (int i = n; i > 1; i--) {
                out.print(i);
                out.print(' ');
                out.println(i - 1);
            }
        } else {
            for (int i = 1; i < n; i++) {
                out.print(i);
                out.print(' ');
                out.println(i + 1);
            }
        }
    }
}
