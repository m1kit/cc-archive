package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ESwappingCharacters {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int k = in.ints(), n = in.ints();
        char[][] s = new char[k][];
        {
            String[] ss = in.string(k);
            IntroSort.sort(ss);
            s[0] = ss[0].toCharArray();
            int cur = 1;
            for (int i = 1; i < k; i++) {
                if (ss[i - 1].equals(ss[i])) continue;
                s[cur++] = ss[i].toCharArray();
            }
            k = cur;
        }

        if (k == 1) {
            out.print(s[0][1]).print(s[0][0]);
            for (int i = 2; i < n; i++) out.print(s[0][i]);
            out.ln();
            return;
        }

        boolean easy = false;
        {
            int[] cnt = new int[26];
            for (int i = 0; i < n; i++) cnt[s[0][i] - 'a']++;
            for (int i = 0; i < k; i++) {
                int[] cnt2 = new int[26];
                for (int j = 0; j < n; j++) cnt2[s[i][j] - 'a']++;
                if (!Arrays.equals(cnt, cnt2)) {
                    out.ans(-1).ln();
                    return;
                }
            }
            for (int j = 0; j < 26; j++) {
                if (cnt[j] >= 2) easy = true;
            }
        }

        List<Integer> ind = new ArrayList<>();
        for (int j = 0; j < 100; j++) {
            int sample0 = (int) (Math.random() * k);
            int sample1 = (int) (Math.random() * k);
            while (sample0 == sample1) sample1 = (int) (Math.random() * k);
            for (int i = 0; i < n; i++) {
                if (s[sample0][i] != s[sample1][i]) ind.add(i);
            }
        }
        ind = new ArrayList<>(new HashSet<>(ind));

        for (int ind0 = 0; ind0 < ind.size(); ind0++) {
            loop:
            for (int ind1 = 0; ind1 < ind0; ind1++) {
                char[] res = s[0].clone();
                char t = res[ind.get(ind0)];
                res[ind.get(ind0)] = res[ind.get(ind1)];
                res[ind.get(ind1)] = t;

                //System.out.println("Trying " + String.valueOf(res));

                for (int i = 0; i < k; i++) {
                    int diff = 0;
                    for (int j = 0; j < n; j++) {
                        if (s[i][j] != res[j]) {
                            diff++;
                        }
                    }
                    if (diff != 2 && (diff != 0 || !easy)) {
                        continue loop;
                    }
                }

                out.ans(String.valueOf(res)).ln();
                return;
            }
        }
        out.ans(-1).ln();
    }
}
