package jp.llv.atcoder;

public class MostFrequentLastDigit {
    public int[] generate(int n, int d) {
        int[] ans = new int[n];
        int off = d < 5 ? 5 : 0;
        for (int i = 0; i < n; i++) {
            ans[i] = off + (i * 10) + (i % 2 == 0 ? (d / 2) : ((d + 1) / 2));
        }
        return ans;
    }
}
