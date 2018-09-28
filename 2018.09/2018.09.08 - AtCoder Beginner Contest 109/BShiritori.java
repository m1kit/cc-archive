package jp.llv.atcoder;

import java.util.HashSet;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Set;

public class BShiritori {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        Set<String> words = new HashSet<>();
        char last = 0;
        for (int i = 0; i < n; i++) {
            String w = in.next();
            if (words.contains(w) || (last > 0 && last != w.charAt(0))) {
                out.println("No");
                return;
            }
            words.add(w);
            last = w.charAt(w.length() - 1);
        }
        out.println("Yes");
    }
}
