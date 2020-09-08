package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class EOxConcatenation {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        String s = in.string();
        int[] c = in.ints(4);

        int[] cnt = new int[2];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'o') {
                cnt[0]++;
            } else {
                cnt[1]++;
            }
        }

        if (c[0] + c[1] + c[2] != cnt[0] || c[0] + c[1] + c[3] != cnt[1]) {
            out.noln();
            return;
        }

        List<String> p = new ArrayList<>();
        int start = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                p.add(s.substring(start, i));
                start = i;
            }
        }
        p.add(s.substring(start));

        //System.out.println(p);

        List<String> oxToken = new ArrayList<>(), xoToken = new ArrayList<>();
        int any = 0;
        for (String token : p) {
            if (token.length() == 1) {
                if (token.charAt(0) == 'o') {
                    c[2]--;
                } else {
                    c[3]--;
                }
            } else if (token.length() % 2 == 1) {
                if (token.charAt(0) == 'o') {
                    c[2]--;
                } else {
                    c[3]--;
                }
                any += (token.length() - 1) / 2;
            } else {
                if (token.charAt(0) == 'o') {
                    oxToken.add(token);
                } else {
                    xoToken.add(token);
                }
            }
        }
        oxToken.sort(Comparator.comparing(String::length));
        xoToken.sort(Comparator.comparing(String::length));

        for (String token : oxToken) {
            int len = token.length() / 2;
            int nat = Math.min(c[0], len);
            c[0] -= nat;
            len -= nat;
            if (len > 0) {
                c[2]--;
                c[3]--;
                c[1] -= len - 1;
            }
        }

        for (String token : xoToken) {
            int len = token.length() / 2;
            int nat = Math.min(c[1], len);
            c[1] -= nat;
            len -= nat;
            if (len > 0) {
                c[2]--;
                c[3]--;
                c[0] -= len - 1;
            }
        }

        if (c[2] < 0 || c[3] < 0 || c[0] < 0 || c[1] < 0) {
            out.noln();
            return;
        }

        out.yesln();
    }
}
