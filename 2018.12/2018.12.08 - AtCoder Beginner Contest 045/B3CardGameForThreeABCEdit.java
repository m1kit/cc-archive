package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class B3CardGameForThreeABCEdit {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        String[] s = in.string(3);
        int turn = 0;
        while (!s[turn].isEmpty()) {
            int c = s[turn].charAt(0) - 'a';
            s[turn] = s[turn].substring(1);
            turn = c;
        }
        out.println((char) (turn + 'A'));
    }
}
