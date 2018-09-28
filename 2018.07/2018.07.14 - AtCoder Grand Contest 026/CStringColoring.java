package jp.llv.atcoder;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import java.io.PrintWriter;

public class CStringColoring {

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        String s = in.next();
        String left = s.substring(0, n);
        String right = s.substring(n, n * 2);

        HashMap<Pair, Integer> map = new HashMap<>();
        for (int i = 0; i < 1 << n; i++) {
            StringBuilder red = new StringBuilder();
            StringBuilder blue = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if ((i >> j) % 2 == 1) {
                    red.append(right.charAt(j));
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if ((i >> j) % 2 == 0) {
                    blue.append(right.charAt(j));
                }
            }
            Pair tmp = new Pair(red.toString(), blue.toString());
            if (map.containsKey(tmp)) {
                int x = map.get(tmp);
                map.put(tmp, x + 1);
            } else {
                map.put(tmp, 1);
            }
        }

        long ans = 0;
        for (int i = 0; i < 1 << n; i++) {
            StringBuilder red = new StringBuilder();
            StringBuilder blue = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if ((i >> j) % 2 == 1) {
                    red.append(left.charAt(j));
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if ((i >> j) % 2 == 0) {
                    blue.append(left.charAt(j));
                }
            }
            Pair tmp = new Pair(blue.toString(), red.toString());
            if (map.containsKey(tmp)) {
                ans += map.get(tmp);
            }
        }
        out.println(ans);
    }

    private static class Pair {
        String left;
        String right;

        Pair(String left, String right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return Objects.equals(left, pair.left) &&
                    Objects.equals(right, pair.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(left, right);
        }
    }
}
