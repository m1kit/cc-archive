package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class AWannaGoBackHome {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        String s = in.string();
        int mask = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
                case 'N':
                    mask |= 0b0001;
                    break;
                case 'S':
                    mask |= 0b0010;
                    break;
                case 'E':
                    mask |= 0b0100;
                    break;
                case 'W':
                    mask |= 0b1000;
                    break;
            }
        }
        if (mask == 3 || mask == 12 || mask == 15) {
            out.println(YES);
        } else {
            out.println(NO);
        }
    }
}
