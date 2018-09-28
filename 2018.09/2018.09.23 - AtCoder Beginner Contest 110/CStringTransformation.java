package jp.llv.atcoder;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class CStringTransformation {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int[] index = new int[26];
        Arrays.fill(index, -1);
        String s = in.next(), t = in.next();
        for (int i = 0; i < s.length(); i++) {
            int c = t.charAt(i) - 'a';
            if (index[c] >= 0 && s.charAt(index[c]) != s.charAt(i)) {
                out.println("No");
                return;
            }
            index[c] = i;
        }
        Arrays.fill(index, -1);
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (index[c] >= 0 && t.charAt(index[c]) != t.charAt(i)) {
                out.println("No");
                return;
            }
            index[c] = i;
        }
        out.println("Yes");
    }
}
