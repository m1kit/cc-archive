package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class CBackAndForth {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;
    private static final int[] MVX = {0, 1, 0, -1, 0, 1, 1, -1, -1};
    private static final int[] MVY = {0, 0, 1, 0, -1, 1, -1, -1, 1};

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int sx = in.ints(), sy = in.ints(), tx = in.ints(), ty = in.ints();
        int dx = tx - sx, dy = ty - sy;
        IntStream.range(0, dy).forEach(i -> out.print('U'));
        IntStream.range(0, dx).forEach(i -> out.print('R'));
        IntStream.range(0, dy).forEach(i -> out.print('D'));
        IntStream.range(0, dx).forEach(i -> out.print('L'));
        out.print('L');
        IntStream.range(0, dy + 1).forEach(i -> out.print('U'));
        IntStream.range(0, dx + 1).forEach(i -> out.print('R'));
        out.print('D');
        out.print('R');
        IntStream.range(0, dy + 1).forEach(i -> out.print('D'));
        IntStream.range(0, dx + 1).forEach(i -> out.print('L'));
        out.println('U');
    }
}
