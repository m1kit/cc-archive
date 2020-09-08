package dev.mikit.atcoder;

public class WarmupWithRooks {
    public int count(String[] board) {
        int ans = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i].charAt(j) == '.') continue;
                char me = board[i].charAt(j);
                char ot = me == 'B' ? 'W' : 'B';
                for (int k = j + 1; k < 8; k++) {
                    if (board[i].charAt(k) == ot) ans++;
                    if (board[i].charAt(k) != '.') break;
                }
                for (int k = j - 1; k >= 0; k--) {
                    if (board[i].charAt(k) == ot) ans++;
                    if (board[i].charAt(k) != '.') break;
                }
                for (int k = i + 1; k < 8; k++) {
                    if (board[k].charAt(j) == ot) ans++;
                    if (board[k].charAt(j) != '.') break;
                }
                for (int k = i - 1; k >= 0; k--) {
                    if (board[k].charAt(j) == ot) ans++;
                    if (board[k].charAt(j) != '.') break;
                }
            }
        }
        return ans / 2;
    }
}
