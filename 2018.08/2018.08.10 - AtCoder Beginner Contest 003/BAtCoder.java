package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class BAtCoder {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next();
        String t = in.next();
        String a = "@atcoder";
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) == '@' && a.contains(""+t.charAt(i))) || (t.charAt(i) == '@' && a.contains(""+s.charAt(i))) || s.charAt(i) == t.charAt(i)) {
                continue;
            }
            out.println("You will lose");
            return;
        }
        out.println("You can win");
    }
}
