package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class BCollectingBallsEasyVersion {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        int k = in.ints();
        out.println(2 * IntStream.range(0, n).map(x -> in.ints()).map(y -> Math.min(y, k - y)).sum());
    }
}
