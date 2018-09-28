package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class AUOIAUAI {

    private static final String YES = "vowel";
    private static final String NO = "consonant";
    private static final int MOD = (int) 1e9 + 7;
    private static final int[] MVX = {0, 1, 0, -1, 0, 1, 1, -1, -1};
    private static final int[] MVY = {0, 0, 1, 0, -1, 1, -1, -1, 1};
    private static final int[] VOWELS = {'a', 'e', 'i', 'o', 'u'};

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        char c = in.string().charAt(0);
        if (Arrays.stream(VOWELS).anyMatch(x -> x == c)) {
            out.println(YES);
        } else {
            out.println(NO);
        }
    }
}
