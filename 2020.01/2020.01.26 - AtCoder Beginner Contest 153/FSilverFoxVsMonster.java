package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.geo.g2d.Vec2l;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Queue;

public class FSilverFoxVsMonster {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long d = in.longs() * 2, a = in.longs();
        Monster[] monsters = new Monster[n];
        for (int i = 0; i < n; i++) {
            monsters[i] = new Monster(in.longs(), (in.longs() + a - 1) / a);
        }
        IntroSort.sort(monsters, Comparator.comparing(monster -> monster.x));
        Queue<Vec2l> q = new ArrayDeque<>();
        long c = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && q.peek().x < monsters[i].x) c -= q.poll().y;
            long r = Math.max(0, monsters[i].h - c);
            ans += r;
            c += r;
            q.offer(new Vec2l(monsters[i].x + d, r));
        }
        out.ans(ans).ln();
    }

    private static class Monster {
        long x, h;

        Monster(long x, long h) {
            this.x = x;
            this.h = h;
        }
    }

}
