package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.math.mod.ModMath;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EBullet {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long ans = 1;
        int origin = 0;
        ModMath mod = new ModMath(MOD);
        Map<Direction, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long x = in.longs(), y = in.longs();
            if (x == 0 && y == 0) origin++;
            else map.merge(new Direction(x, y), 1, Integer::sum);
        }
        //System.out.println(map);
        Set<Direction> counted = new HashSet<>();
        for (Direction dir : map.keySet()) {
            Direction opp = dir.rot90();
            if (counted.contains(dir) || counted.contains(opp)) continue;
            int a = map.get(dir), b = map.getOrDefault(opp, 0);
            long d = (mod.pow(2, a) + mod.pow(2, b) + MOD - 1) % MOD;
            //System.out.println(dir + "*" + a + ", " + opp + "*" + b + " => " + d);
            ans *= d;
            ans %= MOD;
            counted.add(dir);
            counted.add(opp);
        }
        ans = (ans + origin + MOD - 1) % MOD;
        out.ans(ans).ln();
    }

    private static class Direction {
        final long x, y;

        Direction(long x, long y) {
            if (x == 0) y = 1;
            else if (y == 0) x = 1;
            else {
                if (x < 0) {
                    x = -x;
                    y = -y;
                }
                long g = IntMath.gcd(x, Math.abs(y));
                x /= g;
                y /= g;
            }
            this.x = x;
            this.y = y;
        }

        Direction rot90() {
            return new Direction(-y, x);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Direction d = (Direction) o;
            return x == d.x && y == d.y;
        }

        @Override
        public int hashCode() {
            int result = (int) (x ^ (x >>> 32));
            result = 31 * result + (int) (y ^ (y >>> 32));
            return result;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
}
