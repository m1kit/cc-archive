package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class ESynchronizedSubsequence {
    String s;
    int[] a;
    int[] b;
    int[] index ;
    boolean[] use;
    int n , n2;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        n = in.nextInt();
        n2 = n * 2;
        s = in.next();
        a = new int[n];
        b = new int[n];
        index = new int[n2];
        use = new boolean[n2];

        int ai = 0, bi = 0;
        for (int i = 0; i < n2; i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                index[i] = ai;
                a[ai++] = i;
            } else {
                index[i] = bi;
                b[bi++] = i;
            }
        }

        // 本体を作ります
        int lastUsedBIndex = -1;
        for (int i = findsaicho(0, 0); i < n2; i++) {
            if (use[i]) { // もう使えません
                continue;
            }
            char c = s.charAt(i);
            if (c == 'b') {
                lastUsedBIndex = i;
                use[i] = true;
                use[a[index[i]]] = true; //仕方ないので使う
            } else {
                i = b[index[i]];
            }
        }

        // 尻尾を生やします
        int lastIgnoredAIndex = -1;
        int lastIgnoredAIndexBaked = -1;
        for (int i = lastUsedBIndex + 1; i < n2; i++) {
            if (use[i]) { // もう使えません
                continue;
            }
            char c = s.charAt(i);
            if (c == 'a') {
                lastIgnoredAIndex = index[i];
            } else if (index[i] > lastIgnoredAIndexBaked) {
                lastIgnoredAIndexBaked = lastIgnoredAIndex;
                use[i] = true;
                use[a[index[i]]] = true; //仕方ないので使う
            }
        }

        // 出力
        for (int i = 0; i < n2; i++) {
            if (use[i]) {
                out.print(s.charAt(i));
            }
        }
        out.println();
    }

    private int findsaicho(int start, int min) {
        int res = -1;
        int countOfB = 0;
        int firstB = -1;
        for (int i = start; i < n2; i++) {
            if (s.charAt(i) == 'b') {
                if (firstB < 0) {
                    firstB = i;
                } else {

                }
            } else {
                if (firstB < 0) {
                    firstB = i;
                } else {

                }
            }
        }
    }
}
