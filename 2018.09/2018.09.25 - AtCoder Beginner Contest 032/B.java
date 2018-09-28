package jp.llv.atcoder;

import java.util.HashSet;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Set;

public class B {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        Set<String> choice = new HashSet<>();
        String s = in.next();
        int k = in.nextInt();
        for (int i = 0; i + k <= s.length(); i++) {
            choice.add(s.substring(i, i + k));
        }
        out.println(choice.size());
    }
}
