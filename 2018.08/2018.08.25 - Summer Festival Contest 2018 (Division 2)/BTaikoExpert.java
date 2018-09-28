package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class BTaikoExpert {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        String s = in.next();
        int q = 1;
        boolean k = false;
        for (int i = 0; i < n; i++) {
            if (k) {
                switch (s.charAt(i)) {
                    case 'D':
                        out.println(0);
                        return;
                }
            } else {
                switch (s.charAt(i)) {
                    case 'K':
                        k = true;
                        break;
                    case '?':
                        q++;
                        break;
                    case 'D':
                        q = 1;
                        break;
                }
            }
        }
        out.println(q);
    }
}
