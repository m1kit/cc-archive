package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.math.geo.g2d.Vec2i;

import java.util.HashMap;
import java.util.HashSet;

public class C2PowerTransmissionHardEdition {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        Vec2i[] vs = new Vec2i[n];
        for (int i = 0; i < n; i++) {
            vs[i] = new Vec2i(in.ints(), in.ints());
        }
        HashMap<Wire, Integer> cnt = new HashMap<>();
        HashSet<Line> lines = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                Line line = new Line(vs[i].x, vs[j].x, vs[i].y, vs[j].y);
                if (lines.contains(line)) continue;
                lines.add(line);
                cnt.merge(line.toWire(), 1, Integer::sum);
            }
        }

        //System.out.println(lines);
        //System.out.println(cnt);

        long total = lines.size();
        long ans = 0;
        for (int i : cnt.values()) {
            ans += (total - i) * i;
        }
        out.ans(ans / 2).ln();
    }

    private static class Line {
        int dx, dy, t;

        public Line(int x1, int x2, int y1, int y2) {
            int dx = x1 - x2;
            int dy = y1 - y2;
            if (dx < 0) {
                dx *= -1;
                dy *= -1;
            }

            if (dx == 0) {
                dy /= dy;
            } else if (dy == 0) {
                dx /= dx;
            } else {
                int gcd = IntMath.gcd(dx, Math.abs(dy));
                dx /= gcd;
                dy /= gcd;
            }
            
            this.dx = dx;
            this.dy = dy;
            this.t = dx * y1 - dy * x1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Line line = (Line) o;

            if (dx != line.dx) return false;
            if (dy != line.dy) return false;
            return t == line.t;

        }

        @Override
        public int hashCode() {
            int result = dx;
            result = 31 * result + dy;
            result = 31 * result + t;
            return result;
        }

        public Wire toWire() {
            return new Wire(dx, dy);
        }

        @Override
        public String toString() {
            return "Line{" +
                    "dx=" + dx +
                    ", dy=" + dy +
                    ", t=" + t +
                    '}';
        }
    }

    private static class Wire {
        int dx, dy;

        public Wire(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Wire wire = (Wire) o;

            if (dx != wire.dx) return false;
            return dy == wire.dy;

        }

        @Override
        public int hashCode() {
            int result = dx;
            result = 31 * result + dy;
            return result;
        }

        @Override
        public String toString() {
            return "Wire{" +
                    "dx=" + dx +
                    ", dy=" + dy +
                    '}';
        }
    }
}
