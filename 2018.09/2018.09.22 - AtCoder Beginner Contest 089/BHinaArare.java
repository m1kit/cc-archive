package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class BHinaArare {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        out.println(IntStream.range(0, in.nextInt()).mapToObj(x -> in.next()).distinct().count() == 3 ? "Three" : "Four");
    }
}
