package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CThreeCircuits {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints();
        int[] cnt = new int[n];
        List<List<Integer>> neg = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            neg.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = in.ints() - 1, b = in.ints() - 1;
            cnt[a]++;
            neg.get(a).add(b);
            cnt[b]++;
            neg.get(b).add(a);
        }

        int cr = 0;
        boolean[] isCr = new boolean[n];
        boolean flg = false;
        for (int i = 0; i < n; i++) {
            if (cnt[i] % 2 == 1) {
                out.ansln(NO); //OK
                return;
            } else if (cnt[i] >= 6) {
                flg = true;
            } else if (cnt[i] == 4) {
                cr++;
                isCr[i] = true;
            }
        }
        if (flg) {
            out.ansln(YES);
            return;
        } else if (cr >= 3) {
            out.ansln(YES);
            return;
        } else if (cr <= 1) {
            out.ansln(NO);
            return;
        }

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!isCr[i]) {
                continue;
            }
            Stack<Visit> st = new Stack<>();
            st.add(new Visit(i, 0));
            while (!st.isEmpty()) {
                Visit p = st.pop();
                visited[p.dest] = true;
                for (Integer b : neg.get(p.dest)) {
                    if (b == i && p.depth > 1) {
                        out.ansln(YES);
                        return;
                        //throw new RuntimeException();
                    } else if (isCr[b] || visited[b]) {
                        continue;
                    }
                    st.push(new Visit(b, p.depth + 1));
                }
            }
        }
        out.ansln(NO);
    }

    private static class Visit {
        int dest, depth;

        public Visit(int dest, int depth) {
            this.dest = dest;
            this.depth = depth;
        }
    }
}
