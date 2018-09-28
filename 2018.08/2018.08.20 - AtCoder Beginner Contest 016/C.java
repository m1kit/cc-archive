package jp.llv.atcoder;

import java.util.*;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        List<Set<Integer>> friends = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            friends.add(new HashSet<>());
        }
        for (int i = 0; i < m; i++) {
            int a = in.nextInt() - 1, b = in.nextInt() - 1;
            friends.get(a).add(b);
            friends.get(b).add(a);
        }
        for (int i = 0; i < n; i++) {
            Set<Integer> friend = friends.get(i);
            Set<Integer> ff = new HashSet<>();
            for (int f : friend) {
                ff.addAll(friends.get(f));
            }
            ff.removeAll(friend);
            ff.remove(i);
            out.println(ff.size());
        }
    }
}
