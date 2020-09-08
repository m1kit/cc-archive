package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class EPolycarpAndSnakes {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        int testCases = in.ints();
        char[][] board = new char[2000][];
        int[] maxX = new int[26], minX = new int[26];
        int[] maxY = new int[26], minY = new int[26];

        loop:
        for (int testCase = 0; testCase < testCases; testCase++) {
            int h = in.ints(), w = in.ints();
            for (int i = 0; i < h; i++) {
                board[i] = in.string().toCharArray();
            }
            Arrays.fill(maxX, -1);
            Arrays.fill(maxY, -1);
            Arrays.fill(minX, Integer.MAX_VALUE);
            Arrays.fill(minY, Integer.MAX_VALUE);

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    char c = board[i][j];
                    if (c == '.') continue;
                    maxX[c - 'a'] = Math.max(maxX[c - 'a'], j);
                    maxY[c - 'a'] = Math.max(maxY[c - 'a'], i);
                    minX[c - 'a'] = Math.min(minX[c - 'a'], j);
                    minY[c - 'a'] = Math.min(minY[c - 'a'], i);
                }
            }

            int maxChar = -1, tmpX = -1, tmpY = -1;
            for (int i = 0; i < 26; i++) {
                if (maxX[i] == -1) continue;
                maxChar = Math.max(maxChar, i);
                tmpX = minX[i];
                tmpY = minY[i];
                if (maxX[i] == minX[i]) {
                    int x = maxX[i];
                    for (int j = minY[i]; j <= maxY[i]; j++) {
                        if (board[j][x] == '.' || board[j][x] - 'a' < i) {
                            out.noln();
                            continue loop;
                        }
                    }
                } else if (maxY[i] == minY[i]) {
                    int y = maxY[i];
                    for (int j = minX[i]; j <= maxX[i]; j++) {
                        if (board[y][j] == '.' || board[y][j] - 'a' < i) {
                            out.noln();
                            continue loop;
                        }
                    }
                } else {
                    out.noln();
                    continue loop;
                }
            }
            maxChar++;

            /*for (int i = 1; i < h - 1; i++) {
                for (int j = 0; j < w; j++) {
                    char c = board[i][j];
                    if (c == '.') continue;
                    if (board[i - 1][j] == '.' || board[i + 1][j] == '.') continue;
                    if (board[i - 1][j] != board[i + 1][j]) continue;
                    if (board[i - 1][j] <= c) continue;
                    //System.out.println("VERTICAL MISOVERWRITE");
                    out.noln();
                    continue loop;
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 1; j < w - 1; j++) {
                    char c = board[i][j];
                    if (c == '.') continue;
                    if (board[i][j - 1] == '.' || board[i][j + 1] == '.') continue;
                    if (board[i][j - 1] != board[i][j + 1]) continue;
                    if (board[i][j - 1] <= c) continue;
                    //System.out.println("HORIZONTAL MISOVERWRITE");
                    out.noln();
                    continue loop;
                }
            }*/

            out.yesln().ans(maxChar).ln();
            for (int i = 0; i < maxChar; i++) {
                if (maxX[i] == -1) {
                    out.ans(tmpY + 1).ans(tmpX + 1).ans(tmpY + 1).ans(tmpX + 1).ln();
                } else {
                    out.ans(minY[i] + 1).ans(minX[i] + 1).ans(maxY[i] + 1).ans(maxX[i] + 1).ln();
                }
            }
        }
    }
}
