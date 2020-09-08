package dev.mikit.atcoder;

public class EllysWhatDidYouGet {
    public int getCount(int n) {
        int ans = 0;
        for (int x = 1; x <= 50; x++) {
            for (int y = 1; y <= 50; y++) {
                mid: for (int z = 1; z <= 50; z++) {
                    int num = sum((x + y) * z);
                    for (int i = 1; i <= n; i++) if (sum((x * i + y) * z) != num) continue mid;
                    ans++;
                }
            }
        }
        return ans;
    }

    private static int sum(int x) {
        int res = 0;
        while (x > 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}
