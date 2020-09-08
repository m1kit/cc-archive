package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.Factorial;
import dev.mikit.atcoder.lib.math.mod.ModMath;

import java.util.ArrayList;
import java.util.List;

public class FDistributingIntegers {

    private static int N;
    private static final int MOD = (int) 1e9 + 7;
    private static final ModMath MODS = new ModMath(MOD);
    private static final Factorial FACTS = MODS.getFactorial(200005);

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        N = in.ints();
        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) nodes[i] = new Node(i);
        for (int i = 1; i < N; i++) {
            int x = in.ints() - 1, y = in.ints() - 1;
            nodes[x].adj.add(nodes[y]);
            nodes[y].adj.add(nodes[x]);
        }
        nodes[0].up(null);
        nodes[0].down(null, 1);
        for (int i = 0; i < N; i++) {
            out.ans(nodes[i].down).ln();
        }
    }

    private static class Node {
        private final int index;
        private int size = 1;
        private long up = 1, down = 1;
        private final List<Node> adj = new ArrayList<>();

        Node(int index) {
            this.index = index;
        }

        void up(Node parent) {
            int count = 0;
            for (Node child : adj) {
                if (child == parent) continue;
                child.up(this);
                count += child.size;
            }
            size += count;
            for (Node child : adj) {
                if (child == parent) continue;
                up *= child.up;
                up %= MOD;
                up *= FACTS.ncr(count, child.size);
                up %= MOD;
                count -= child.size;
            }
        }

        void down(Node parent, long p) {
            int psize = N - this.size;
            down = p;
            down *= FACTS.ncr(N - 1, psize);
            down %= MOD;
            int count = this.size - 1;
            //System.out.println(index + " : " + down);

            for (Node child : adj) {
                if (child == parent) continue;
                down *= child.up;
                down %= MOD;
                down *= FACTS.ncr(count, child.size);
                down %= MOD;
                count -= child.size;
            }
            //System.out.println(index + " : " + down);

            for (Node child : adj) {
                if (child == parent) continue;
                long t = down;
                t *= MODS.inv(child.up);
                t %= MOD;
                t *= MODS.inv(FACTS.ncr(N - 1, child.size));
                t %= MOD;
                child.down(this, t);
            }
        }
    }
}
