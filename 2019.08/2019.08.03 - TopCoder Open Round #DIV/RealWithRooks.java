package dev.mikit.atcoder;

public class RealWithRooks {
    public String[] construct(int r, int c, int n) {
        int w = 0;
        while (w * w <= n) w++;
        int h = (n + w - 1) / w;
        while (h * (w - 1) >= n) w--;
        while (w > c) w--;
        while (w * h < n) h++;
        while (h > r) h--;
        while (w * h < n) w++;

        String[] ans = new String[r];
        for (int i = 0; i < r; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < c; j++) {
                if (n == 0 || i >= h || j >= w) {
                    row.append('.');
                } else if ((i + j) % 2 == 1) {
                    row.append('B');
                    n--;
                } else {
                    row.append('W');
                    n--;
                }
            }
            ans[i] = row.toString();
        }
        return ans;
    }
}
