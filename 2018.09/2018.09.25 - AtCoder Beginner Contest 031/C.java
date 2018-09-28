package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class C {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;
    private static final int[] MVX = {0, 1, 0, -1, 0, 1, 1, -1, -1};
    private static final int[] MVY = {0, 0, 1, 0, -1, 1, -1, -1, 1};

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        int[] a = in.ints(n);
        int ans = Integer.MIN_VALUE;
        for (int firstChoice = 0; firstChoice < n; firstChoice++) {
            int firstMax = Integer.MIN_VALUE;
            int secondMax = Integer.MIN_VALUE;
            for (int secondChoice = 0; secondChoice < n; secondChoice++) {
                if (firstChoice == secondChoice) {
                    continue;
                }
                int l = Math.min(firstChoice, secondChoice);
                int r = Math.max(firstChoice, secondChoice);
                int firstScore = 0;
                int secondScore = 0;
                for (int k = l; k <= r; k++) {
                    if ((k - l) % 2 == 0) {
                        firstScore += a[k];
                    } else {
                        secondScore += a[k];
                    }
                }
                if (secondScore > secondMax) {
                    secondMax = secondScore;
                    firstMax = firstScore;
                }
            }
            ans = Math.max(firstMax, ans);
        }
        out.println(ans);
    }
}
