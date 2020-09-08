package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AWannaGoBackHome {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int[] cnt = new int[4];
        String s = in.string();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'N':
                    cnt[0]++;
                    break;
                case 'S':
                    cnt[1]++;
                    break;
                case 'E':
                    cnt[2]++;
                    break;
                case 'W':
                    cnt[3]++;
                    break;
            }
        }
        if (cnt[0] == 0 && cnt[1] > 0
                || cnt[1] == 0 && cnt[0] > 0
                || cnt[2] == 0 && cnt[3] > 0
                || cnt[3] == 0 && cnt[2] > 0) {
            out.noln();
        } else {
            out.yesln();
        }
    }
}
