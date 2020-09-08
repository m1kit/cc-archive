package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.List;

public class BBallsOfBuma {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        char[] s = (in.string() + "*").toCharArray();
        List<Segment> segs = new ArrayList<>();
        char last = s[0];
        int len = 1;
        for (int i = 1; i < s.length; i++) {
            if (s[i] == last) len++;
            else {
                segs.add(new Segment(last, len));
                last = s[i];
                len = 1;
            }
        }

        if (segs.size() % 2 == 0 || segs.get(segs.size() / 2).len < 2) {
            out.ans(0).ln();
            return;
        }
        for (int i = 0; i < segs.size() / 2; i++) {
            Segment l = segs.get(i), r = segs.get(segs.size() - i - 1);
            if (l.c != r.c || l.len + r.len < 3) {
                out.ans(0).ln();
                return;
            }
        }
        out.ans(segs.get(segs.size() / 2).len + 1).ln();
    }

    private static class Segment {
        char c;
        int len;

        Segment(char c, int len) {
            this.c = c;
            this.len = len;
        }

        @Override
        public String toString() {
            return "('" + c + "' * " + len + ")";
        }
    }
}
