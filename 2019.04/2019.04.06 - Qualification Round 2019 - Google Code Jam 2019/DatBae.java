package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class DatBae {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), b = in.ints(), f = in.ints();
        Segment[] segments = new Segment[(n + 15) / 16];
        {
            for (int i = 0; i < segments.length; i++) {
                segments[i] = new Segment(Math.min(16, n - 16 * i));
            }
            int c = 0;
            for (int i = 0; i < segments.length; i++) {
                for (int j = 0; j < segments[i].width; j++) {
                    out.print((char) (c + '0'));
                }
                c = 1 - c;
            }
            out.ln().flush();

            int cur = 0;
            String res = in.string() + "2";
            for (int i = 0; i < segments.length; i++) {
                if (i + 1 == segments.length && res.charAt(cur) == '2') {
                    segments[i].error = segments[i].width;
                    break;
                }
                int w = 1;
                while (res.charAt(cur) == res.charAt(cur + 1)) {
                    cur++;
                    w++;
                }
                segments[i].error = segments[i].width - w;
                cur++;
            }
        }

        for (int i = 3; i >= 0; i--) {
            int segw = 1 << i;
            Segment[] ns = new Segment[(n + segw - 1) / segw];
            for (int j = 0; j < ns.length; j++) {
                ns[j] = new Segment(Math.min(segw, n - segw * j));
            }
            int c = 0;
            for (int j = 0; j < ns.length; j++) {
                for (int k = 0; k < ns[j].width; k++) {
                    out.print((char) (c + '0'));
                }
                c = 1 - c;
            }
            out.ln().flush();

            int cur = 0;
            String res = in.string() + "2";
            for (int j = 0; j < ns.length; j += 2) {
                Segment par = segments[j / 2];
                String sub = res.substring(cur, cur + par.working()) + "1";
                cur += par.working();
                int left = -1;
                for (int k = 0; k <= par.working(); k++) {
                    if (sub.charAt(k) == '1') {
                        left = k;
                        break;
                    }
                }
                int right = par.working() - left;
                ns[j].error = ns[j].width - left;
                if (j + 1 < ns.length) {
                    ns[j + 1].error = ns[j + 1].width - right;
                }
            }
            segments = ns;
        }

        if (segments.length != n) {
            throw new RuntimeException("ERR=" + segments.length);
        }
        for (int j = 0; j < n; j++) {
            if (segments[j].error > 0) {
                out.ans(j);
            }
        }
        out.ln().flush();
        int v = in.ints();
        if (v == -1) {
            System.exit(0);// WA
        }
    }

    private static class Segment {
        final int width;
        int error;

        public Segment(int width) {
            this.width = width;
        }

        int working() {
            return width - error;
        }

        @Override
        public String toString() {
            return "Segment{" +
                    "width=" + width +
                    ", error=" + error +
                    '}';
        }
    }
}
