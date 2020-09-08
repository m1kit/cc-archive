package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class IncrementalHouseOfPancakes {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setCaseLabel(LightWriter.CaseLabel.GCJ);
        long lo = in.longs(), hi = in.longs();
        out.cases(testNumber);
        boolean rev = false;

        long x;
        {
            long min = 0, max = 2_000_000_000;
            while (max - min > 1) {
                long mid = (min + max) / 2;
                //System.out.println(mid);
                long s = mid * (mid + 1) / 2;
                if (Math.abs(hi - lo) >= s) min = mid;
                else max = mid;
            }
            long st = min * (min + 1) / 2;
            if (lo >= hi) lo -= st;
            else hi -= st;
            x = min;
        }
        while (lo > x || hi > x) {
            if (lo > hi) {
                rev = !rev;
                long t = lo;
                lo = hi;
                hi = t;
            }
            if (lo == hi) {
                lo -= ++x;
                rev = false;
                continue;
            }
            long min = -1, max = 200_000_000;
            while (max - min > 1) {
                long n = (min + max) / 2;
                long dl = n * (n + x + 1), dr = (n + 1) * (n + x + 1);
                if (lo - dl <= hi - dr || lo - dl < 0 || hi - dr < 0) max = n;
                else min = n;
            }
            long cnt = max, dl = max * (max + x + 1), dr = (max + 1) * (max + x + 1);
            if (lo - dl < 0 || hi - dr < 0) {
                cnt = min;
                dl = min * (min + x + 1);
                dr = (min + 1) * (min + x + 1);
            }
            //System.out.println(cnt + " " + lo + " " + hi);
            //if (x > 1000) break;
            //System.out.println(lo + "-" + dl + " " + hi + "-" + dr);
            lo -= dl;
            hi -= dr;
            x += cnt * 2 + 1;

        }

        if (rev) {
            long t = lo;
            lo = hi;
            hi = t;
        }
        out.ans(x).ans(lo).ans(hi).ln();
    }
}
