package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class ABC085BKagamiMochi {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        out.println(IntStream.range(0, in.nextInt()).map(x -> in.nextInt()).distinct().count());
    }
}
