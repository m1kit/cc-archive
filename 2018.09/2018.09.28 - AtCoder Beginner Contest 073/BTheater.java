package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;

import java.io.PrintWriter;
import java.util.stream.IntStream;

public class BTheater {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        out.println(IntStream.range(0, in.ints()).map(i -> 1 - in.ints() + in.ints()).sum());
    }
}