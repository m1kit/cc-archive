package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.math.counting.Permutation;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BNiceTable {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;
    private static final char[] DNA = {'A', 'C', 'G', 'T'};

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints();
        int[][] color = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = in.string();
            for (int j = 0; j < m; j++) {
                color[i][j] = charToInt(s.charAt(j));
            }
        }

        int[][][] row = new int[2][4][n];
        int[][][] col = new int[2][4][m];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                row[x % 2][color[y][x]][y]++;
                col[y % 2][color[y][x]][x]++;
            }
        }

        boolean[] flagsR = new boolean[n];
        boolean[] flagsC = new boolean[m];

        int[][] p = new int[2][2];

        long ans = Long.MAX_VALUE;
        int[][] pattern = new int[2][2];
        boolean[] choice = null;
        boolean type = false;
        for (int z = 1; z < 4; z++) {
            for (int w = 0; w < z; w++) {
                // build pattern
                p[0][0] = w;
                p[0][1] = z;
                int unused = (~((1 << w) | (1 << z))) & 0b1111;
                int c = 0;
                for (int i = 0; i < 4; i++) {
                    if (((1 << i) & unused) > 0) {
                        p[1][c++] = i;
                    }
                }

                long t = 0;
                for (int y = 0; y < n; y++) {
                    int cost1 = m - (row[0][p[y % 2][0]][y] + row[1][p[y % 2][1]][y]);
                    int cost2 = m - (row[1][p[y % 2][0]][y] + row[0][p[y % 2][1]][y]);
                    flagsR[y] = cost1 > cost2;
                    t += Math.min(cost1, cost2);
                }
                if (t < ans) {
                    ans = t;
                    for (int i = 0; i < 4; i++) {
                        pattern[i / 2][i % 2] = p[i / 2][i % 2];
                    }
                    choice = flagsR.clone();
                    type = false;
                }

                t = 0;
                for (int x = 0; x < m; x++) {
                    int cost1 = n - (col[0][p[x % 2][0]][x] + col[1][p[x % 2][1]][x]);
                    int cost2 = n - (col[1][p[x % 2][0]][x] + col[0][p[x % 2][1]][x]);
                    flagsC[x] = cost1 > cost2;
                    t += Math.min(cost1, cost2);
                }
                if (t < ans) {
                    ans = t;
                    for (int i = 0; i < 4; i++) {
                        pattern[i / 2][i % 2] = p[i / 2][i % 2];
                    }
                    choice = flagsC.clone();
                    type = true;
                }
            }
        }
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (!type) {
                    out.print(intToChar(pattern[y % 2][(choice[y] ? x + 1: x) % 2]));
                } else {
                    out.print(intToChar(pattern[x % 2][(choice[x] ? y + 1: y) % 2]));
                }
            }
            out.ln();
        }
        out.enableDebug();
        out.debug(pattern);
        //System.out.println(type);
        //System.out.println(Arrays.deepToString(pattern));
        //System.out.println(ans);
    }


    private static char intToChar(int i) {
        return DNA[i];
    }

    private static int charToInt(char c) {
        switch (c) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
        }
        throw new IllegalArgumentException();
    }
}
