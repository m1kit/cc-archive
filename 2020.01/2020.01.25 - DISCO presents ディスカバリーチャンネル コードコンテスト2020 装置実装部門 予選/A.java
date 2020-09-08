package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.PrimeTable;
import dev.mikit.atcoder.lib.math.geo.g2d.Vec2d;

import java.util.List;

public class A {

    private static final List<Integer> PRIMES = new PrimeTable(5_000_000).gerPrimes();

    private static final int SPEED_MIN = 1;
    private static final int SPEED_MAX = 500;
    private static final int ACC_MIN = 60;
    private static final int ACC_MAX = 3000;


    private static final int SX = 0;
    private static final int SY = 470;
    private static final int AX = 0;
    private static final int AY = 900;
    private static final int BX = 900;
    private static final int BY = 0;
    private static final int CX = 900;
    private static final int CY = 900;
    private static final int EX = 90;
    private static final int EY = 50;

    private static final int MIN_GET = 500;
    private static final int MAX_EJECT = 60000;

    private static int la, lb, lc;
    private static int na, nb, nc, ne;
    private static int ma, mb, mc;
    private static int ta, tb, tc;
    private static int lastX = SX, lastY = SY;
    private static int totalA = 0;
    private static double total;

    private static LightWriter out;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        this.out = out;

        la = in.ints();
        lb = in.ints();
        lc = in.ints();

        na = in.ints();
        nb = in.ints();
        nc = in.ints();
        ne = in.ints();

        ma = in.ints();
        mb = in.ints();
        mc = in.ints();

        tc = in.ints();

        for (int i = 0; i < 10; i++) {
            move(getA());
            get(120_000 / (na + nb + nc), 0, 0, 0);
            ta = 45;
            move(getC());
            get(0, 0, 120_000 / (na + nb + nc), 0);
            move(getB());
            get(0, 120_000 / (na + nb + nc), 0, 0);
            move(getE());
            get(0, 0, 0, (120_000 + ne - 1) / ne);
        }
    }

    private static Vec2d getA() {
        double theta = ta / 180.0 * Math.PI;
        return new Vec2d(AX + la * Math.cos(theta), AY - la * Math.sin(theta));
    }

    private static Vec2d getB() {
        tb = 0;
        if (totalA > 0) {
            int r = PRIMES.get(totalA - 1) % 180;
            tb = Math.min(r, 180 - r);
        }
        double theta = tb / 180.0 * Math.PI;
        return new Vec2d(BX - lb * Math.sin(theta), BY + lb * Math.cos(theta));
    }

    private static Vec2d getC() {
        double theta = tc / 180.0 * Math.PI;
        return new Vec2d(CX - lc * Math.cos(theta), CY - lc * Math.sin(theta));
    }

    private static Vec2d getE() {
        return new Vec2d(EX, EY);
    }

    private static void move(Vec2d d) {
        int x = (int) Math.round(d.x), y = (int) Math.round(d.y);
        output(x, SPEED_MAX, ACC_MAX, ACC_MAX, y, SPEED_MAX, ACC_MAX, ACC_MAX, ta, 0, 0, 0, 0);
        lastX = x;
        lastY = y;
    }

    private static void get(int a, int b, int c, int e) {
        a = Math.min(a, ma);
        b = Math.min(b, mb);
        c = Math.min(c, mc);
        e = Math.min(e, MAX_EJECT);

        if (a != 0) a = Math.max(a, MIN_GET);
        if (b != 0) b = Math.max(b, MIN_GET);
        if (c != 0) c = Math.max(c, MIN_GET);

        output(lastX, SPEED_MIN, ACC_MIN, ACC_MIN, lastY, SPEED_MIN, ACC_MIN, ACC_MIN, ta, a, b, c, e);
        totalA += a;
        total += na * a + nb * b + nc * c - ne * e;

    }

    private static void output(int x, int sx, int ax, int dx,
                               int y, int sy, int ay, int dy,
                               int ta,
                               int ca, int cb, int cc, int ce) {
        System.out.printf("%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d\n",
                x, sx, ax, dy,
                y, sy, ay, dy,
                ta,
                ca, cb, cc, ce);
    }

}
