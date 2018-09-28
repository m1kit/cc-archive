package jp.llv.atcoder;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ABC081BShiftOnly {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        long[] a = IntStream.range(0, in.nextInt()).mapToLong(x -> in.nextLong()).toArray();
        for (int i = 0; ; i++) {
            long m = 1 << i;
            if (Arrays.stream(a).anyMatch(x -> (x & m) > 0)) {
                out.println(i);
                return;
            }
        }
    }
}
