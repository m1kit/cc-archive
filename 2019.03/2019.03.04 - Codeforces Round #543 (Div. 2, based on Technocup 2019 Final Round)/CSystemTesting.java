package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CSystemTesting {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        int n = in.ints(), k = in.ints();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.offer(in.ints());
        }

        int finished = 0;
        int[] start = new int[k];
        int[] id = new int[k];
        int c = 0;
        Arrays.fill(start, -1000);
        int[] end = new int[k];
        boolean[] interesting = new boolean[n];
        for (int t = 0; finished < n; t++) {
            for (int i = 0; i < k; i++) {
                if (end[i] == t) {
                    if (t != 0) {
                        finished++;
                    }
                    if (!q.isEmpty()) {
                        start[i] = t;
                        id[i] = c++;
                        end[i] = t + q.poll();
                    } else {
                        start[i] = -1000;
                        end[i] = -1000;
                        id[i] = -1;
                    }
                }
            }
            int p = (int) Math.round(100.0 * finished / n);
            for (int i = 0; i < k; i++) {
                if (t - start[i] + 1 == p) {
                    //System.out.println("t=" + t + " p=" + p + " start[" + i + "]=" + start[i] + " end[" + i + "]=" + end[i]);
                    interesting[id[i]] = true;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (interesting[i]) {
                ans++;
            }
        }
        out.ansln(ans);
    }
}
