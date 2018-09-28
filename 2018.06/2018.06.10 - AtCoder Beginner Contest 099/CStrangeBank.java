package jp.llv.atcoder;

import java.util.*;
import java.io.PrintWriter;
import java.util.stream.Collectors;

public class CStrangeBank {

    static final int[] CHOICES = {1, 6, 9, 36, 81, 216, 729, 1296, 6561, 7776, 46656, 59049};
    static final int[] C6 = {6, 36, 216, 1296, 7776, 46656};
    static final int[] C9 = {9, 81, 729, 6561, 59049};
    int[] m;


    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        m = new int[n + 1];
        out.println(min(n));
    }

    int min(int n) {
        if (n == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = C6.length - 1; i >= 0; i--) {
            if (n >= C6[i]) {
                min = min(n - C6[i]) + 1;
                break;
            }
        }
        for (int i = C9.length - 1; i >= 0; i--) {
            if (n >= C9[i]) {
                min = Math.min(min, min(n - C9[i]) + 1);
                break;
            }
        }
        if (min == Integer.MAX_VALUE) {
            return min(n - 1) + 1;
        } else {
            return min;
        }
    }

}
