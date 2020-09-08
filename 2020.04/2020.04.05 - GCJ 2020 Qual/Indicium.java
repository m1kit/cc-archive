package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.math.geo.g2d.Vec2i;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Indicium {

    private static Map<Vec2i, int[][]> dp = new HashMap<>();

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setCaseLabel(LightWriter.CaseLabel.GCJ);
        out.setBoolLabel(LightWriter.BoolLabel.POSSIBLE_IMPOSSIBLE_ALL_UP);
        for (int n = 2; n <= 5; n++) {
            int[][] mat = new int[n][n];
            ArrayUtil.fill(mat, -1);
            dfs(n, mat, 0);
        }

        int testCases = in.ints();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            out.cases(testCase);
            int n = in.ints(), k = in.ints();
            Vec2i key = new Vec2i(n, k);
            if (!dp.containsKey(key)) out.noln();
            else {
                int[][] mat = dp.get(key);
                out.yesln();
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        out.ans(mat[i][j] + 1);
                    }
                    out.ln();
                }
            }
        }
        /*
        int[][] mat = new int[N][N];
        ArrayUtil.fill(mat, -1);
        dfs(N, mat, 0, 5);
        //if (!dfs(mat, 0, 10)) return;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                out.ans(mat[i][j] + 1);
            }
            out.ln();
        }*/
    }

    private static void dfs(int n, int[][] mat, int now) {
        if (now == n * n) {
            int diag = 0;
            for (int i = 0; i < n; i++) diag += mat[i][i] + 1;
            Vec2i key = new Vec2i(n, diag);
            if (dp.containsKey(key)) return;
            int[][] cpy = new int[n][n];
            for (int i = 0; i < n; i++) {
                System.arraycopy(mat[i], 0, cpy[i], 0, n);
            }
            dp.put(key, cpy);
        }

        int y = (now + now / n) % n, x = now % n;
        int f = 0;
        for (int i = 0; i < n; i++) {
            if (mat[x][i] >= 0) f |= (1 << mat[x][i]);
            if (mat[i][y] >= 0) f |= (1 << mat[i][y]);
        }
        for (int i = 0; i < n; i++) {
            if (((f >> i) & 1) == 1) continue;
            mat[x][y] = i;
            dfs(n, mat, now + 1);
            mat[x][y] = -1;
        }
        return;
    }
}
