package jp.llv.atcoder;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.PrintWriter;

public class DKatanaThrower {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), h = in.nextInt();
        PriorityQueue<Action> a = new PriorityQueue<>(Comparator.comparing(x -> -x.damage));
        for (int i = 0; i < n; i++) {
            a.add(new Action(false, in.nextInt()));
            a.add(new Action(true, in.nextInt()));
        }
        int ans = 0;
        while (h > 0) {
            Action x = a.poll();
            if (!x.last) {
                ans += (h + x.damage - 1) / x.damage;
                break;
            }
            h -= x.damage;
            ans++;
        }
        out.println(ans);
    }

    private static class Action {
        boolean last = false;
        int damage = 0;

        public Action(boolean last, int damage) {
            this.last = last;
            this.damage = damage;
        }
    }
}
