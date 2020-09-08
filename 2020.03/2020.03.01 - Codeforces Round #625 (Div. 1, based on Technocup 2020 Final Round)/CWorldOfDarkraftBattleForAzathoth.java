package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;
import dev.mikit.atcoder.lib.structure.segmenttree.IntLazySegmentTree;
import dev.mikit.atcoder.lib.structure.segmenttree.IntSegmentTree;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CWorldOfDarkraftBattleForAzathoth {

    private static final int MAX = 1_000_004;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints(), p = in.ints();
        Equipment[] weapons = new Equipment[n], armors = new Equipment[m];
        for (int i = 0; i < n; i++) weapons[i] = new Equipment(in.ints(), in.longs());
        for (int i = 0; i < m; i++) armors[i] = new Equipment(in.ints(), in.longs());
        weapons = reduce(weapons);
        armors = reduce(armors);
        n = weapons.length;
        m = armors.length;
        Enemy[] enemies = new Enemy[p];
        for (int i = 0; i < p; i++) enemies[i] = new Enemy(in.ints(), in.ints(), in.longs());
        IntroSort.sort(enemies, Comparator.comparing(enemy -> enemy.weapon));

        long[] costArray = new long[MAX];
        for (int i = 0; i < armors[0].power; i++) costArray[i] = -armors[0].cost;
        for (int i = 1; i < m; i++) {
            for (int j = armors[i - 1].power; j < armors[i].power; j++) costArray[j] = -armors[i].cost;
        }
        for (int i = armors[m - 1].power; i < MAX; i++) costArray[i] = Integer.MIN_VALUE;


        IntLazySegmentTree st = new IntLazySegmentTree(costArray, Math::max, Integer.MIN_VALUE, Long::sum, Long::sum, 0);
        int cur = 0;
        long ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            while (cur < p && enemies[cur].weapon < weapons[i].power) {
                st.update(enemies[cur].armor, MAX, enemies[cur].gain);
                cur++;
            }
            ans = Math.max(ans, st.query(0, MAX) - weapons[i].cost);
        }
        out.ans(ans).ln();
    }

    private static class Equipment implements Comparable<Equipment> {
        int power;
        long cost;

        Equipment(int power, long cost) {
            this.power = power;
            this.cost = cost;
        }

        @Override
        public int compareTo(Equipment o) {
            if (power == o.power) return Long.compare(o.cost, cost);
            return Integer.compare(power, o.power);
        }
    }

    private static class Enemy {
        int weapon, armor;
        long gain;

        Enemy(int weapon, int armor, long gain) {
            this.weapon = weapon;
            this.armor = armor;
            this.gain = gain;
        }
    }

    private static Equipment[] reduce(Equipment[] a) {
        IntroSort.sort(a, Comparator.comparing(e -> e.power));
        List<Equipment> res = new ArrayList<>();
        int n = a.length;
        long minCost = Long.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (a[i].cost < minCost) {
                res.add(a[i]);
                minCost = a[i].cost;
            }
        }
        Equipment[] b = res.toArray(new Equipment[0]);
        ArrayUtil.reverse(b, 0, b.length);
        return b;
    }
}
