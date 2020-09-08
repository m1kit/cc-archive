package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

public class BTheWorldIsJustAProgrammingTaskHardVersion {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        char[] s = in.string().toCharArray();
        int close = 0;
        for (int i = 0; i < n; i++) close += s[i] - '(';
        if (close * 2 != n) {
            out.ans(0).ln()
                    .ans(1).ans(1).ln();
            return;
        }


        int base = 0;
        int[] depth = new int[n], another = new int[n];
        int[][] sum = new int[2][2 * n + 1];
        {
            int d = 0;
            for (int i = 0; i < n; i++) {
                if (s[i] == '(') d++;
                else d--;
                base = Math.min(base, d);
                depth[i] = d;
            }
        }
        {
            int offset = -1;
            for (int i = 0; i < n; i++) {
                if (depth[i] - base == 0) {
                    offset = (i + 1) % n;
                    break;
                }
            }
            Stack<Integer> st = new Stack<>();
            for (int j = 0; j < n; j++) {
                int i = (offset + j) % n;
                if (s[i] == '(') st.push(i);
                else {
                    int a = st.pop();
                    another[a] = i < a ? i + n : i;
                    another[i] = a;
                }
            }
        }


        {
            for (int i = 0; i < 2 * n; i++) {
                if (s[i % n] == '(' || depth[i % n] - base != 1) {
                    sum[0][i + 1] = sum[0][i];
                } else sum[0][i + 1] = sum[0][i] + 1;
                if (s[i % n] == '(' || depth[i % n] - base != 2) {
                    sum[1][i + 1] = sum[1][i];
                } else sum[1][i + 1] = sum[1][i] + 1;
            }
        }

        int a = 0, b = 0, ans = eval(s, a, b);
        {
            int cnt = -1, x = 0, y = 0;
            for (int i = 0; i < n; i++) {
                if (s[i] == '(' && depth[i] - base == 1) {
                    int c = sum[0][another[i]] - sum[0][i + 1];
                    if (c > cnt) {
                        cnt = c;
                        x = i;
                        y = another[i] % n;
                    }
                }
            }
            if (cnt >= 0) {
                int t = eval(s, x, y);
                if (t > ans) {
                    ans = t;
                    a = x;
                    b = y;
                }
            }
        }
        {
            //System.out.println(Arrays.toString(sum[1]));
            int cnt = -1, x = 0, y = 0;
            for (int i = 0; i < n; i++) {
                if (s[i] == '(' && depth[i] - base == 2) {
                    int c = sum[1][another[i]] - sum[1][i + 1];
                    //System.out.println("FOUND: " + i + "~" + (another[i]) + ":" + (sum[1][another[i]] - sum[1][i + 1]));
                    if (c > cnt) {
                        cnt = c;
                        x = i;
                        y = another[i] % n;
                    }
                }
            }
            if (cnt >= 0) {
                int t = eval(s, x, y);
                if (t > ans) {
                    ans = t;
                    a = x;
                    b = y;
                }
            }
        }


        out.ans(ans).ln()
                .ans(Math.min(a, b) + 1).ans(Math.max(a, b) + 1).ln();

        //System.out.println(Arrays.toString(cnt));
    }

    private static void swap(char[] s, int x, int y) {
        char t = s[x];
        s[x] = s[y];
        s[y] = t;
    }

    private static int eval(char[] s, int x, int y) {
        swap(s, x, y);
        int base = 0;
        {
            int d = 0;
            for (char c : s) {
                if (c == '(') d++;
                else d--;
                base = Math.min(base, d);
            }
        }

        int ans = 0;
        {
            int d = 0;
            for (char c : s) {
                if (c == '(') d++;
                else d--;
                if (c == ')' && d - base == 0) ans++;
            }
        }
        swap(s, x, y);
        return ans;
    }
}
