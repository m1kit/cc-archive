package jp.llv.atcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            m.merge(in.next(), 1, (v1, v2) -> v1 + v2);
        }
        String name = "mikit";
        int value = 0;
        for (Map.Entry<String, Integer> e : m.entrySet()) {
            if (e.getValue() > value) {
                name = e.getKey();
                value = e.getValue();
            }
        }
        out.println(name);
    }
}
