package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class B {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        out.println(
                IntStream.range(0, 12)
                        .mapToObj(i -> in.next())
                        .filter(s -> s.contains("r"))
                        .count()
        );
    }
}
