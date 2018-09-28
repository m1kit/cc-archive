package jp.llv.atcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class DCandyDistribution {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        Map<Integer, Integer> values = new HashMap<>();
        values.put(0, 1);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += in.nextInt();
            sum %= m;
            values.merge(sum, 1, (v1, v2) -> v1 + v2);
        }
        out.println(values.values().stream().mapToLong(i -> (i - 1L) * i / 2).sum());
    }
}
