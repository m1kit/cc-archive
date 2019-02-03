package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DGridColoring {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int h = in.ints(), w = in.ints();
        int n = in.ints();
        int[] a = in.ints(n);
        int[][] c = new int[h][w];
        int offset = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < a[i]; j++) {
                int index = offset + j;
                //System.out.println(index);
                int y = index / w;
                if (y % 2 == 0) {
                    c[y][index % w] = i + 1;
                } else {
                    c[y][w - (index % w) - 1] = i + 1;
                }
            }
            offset += a[i];
        }
        Arrays.stream(c)
                .map(x -> IntStream.of(x).mapToObj(Integer::toString).collect(Collectors.joining(" ")))
                .forEach(out::println);
    }
}
