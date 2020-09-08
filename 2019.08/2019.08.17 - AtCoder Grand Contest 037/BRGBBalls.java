package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.Factorial;
import dev.mikit.atcoder.lib.math.mod.ModMath;

import java.util.Arrays;

public class BRGBBalls {

    private static final int MOD = 998244353;

    enum Type {
        START, MID, END
    }

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), n3 = n * 3;
        ModMath mod = new ModMath(MOD);
        Factorial fact = mod.getFactorial(n3 + 1);
        char[] s = in.string()
                .replace('R', (char) 0)
                .replace('G', (char) 1)
                .replace('B', (char) 2).toCharArray();
        // Det
        Type[] types = new Type[n3];
        int[] stc = new int[n3];
        {
            int lcnt = 0, lcol = 0;
            int[] endreq = new int[3];
            for (int i = 0; i < n3; i++) {
                if (endreq[s[i]] > 0) {
                    types[i] = Type.END;
                    endreq[s[i]]--;
                } else if (lcnt == 0 || lcol == s[i]) {
                    types[i] = Type.START;
                    lcol = s[i];
                    lcnt++;
                } else {
                    stc[i] = lcol;
                    types[i] = Type.MID;
                    lcnt--;
                    endreq[3 - (s[i] + lcol)]++;
                }
            }
        }
        //System.out.println(Arrays.toString(types));

        // Start
        long ans = 1;
        {
            int[] count = new int[3];
            for (int i = 0; i < n3; i++) {
                if (types[i] == Type.END) continue;
                if (types[i] == Type.START) count[s[i]]++;
                else {
                    ans *= count[stc[i]]--;
                    ans %= MOD;
                }
            }
        }

        // End
        {
            int[] count = new int[3];
            for (int i = n3 - 1; i >= 0; i--) {
                if (types[i] == Type.START) continue;
                if (types[i] == Type.END) count[s[i]]++;
                else {
                    ans *= count[3 - (s[i] + stc[i])]--;
                    ans %= MOD;
                }
            }
        }

        out.ans(ans * fact.fact(n) % MOD).ln();
    }
}
