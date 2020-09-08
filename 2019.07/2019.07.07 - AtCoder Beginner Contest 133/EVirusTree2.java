package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.Factorial;
import dev.mikit.atcoder.lib.math.mod.ModMath;

import java.util.ArrayList;
import java.util.List;

public class EVirusTree2 {

    private static final int MOD = (int) 1e9 + 7;
    private static final ModMath MM = new ModMath();
    private static final Factorial FA = MM.getFactorial(100_001);


    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), k = in.ints();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 1; i < n; i++) {
            int a = in.ints() - 1, b = in.ints() - 1;
            nodes[a].adj.add(nodes[b]);
            nodes[b].adj.add(nodes[a]);
        }
        nodes[0].treenize(null);
        out.ans(nodes[0].calcRoot(k));
    }

    static class Node {
        int index;
        final List<Node> adj = new ArrayList<>();

        Node(int index) {
            this.index = index;
        }

        void treenize(Node par) {
            adj.remove(par);
            for (Node child : adj) child.treenize(this);
        }

        int childLen() {
            return adj.size();
        }

        long calcRoot(int k) {
            long ans = k;
            ans *= FA.ncr(k - 1, childLen());
            ans %= MOD;
            ans *= FA.fact(childLen());
            ans %= MOD;
            for (Node child : adj) {
                ans *= child.calc(k);
                ans %= MOD;
            }
            return ans;
        }

        long calc(int k) {
            long ans = 1;
            ans *= FA.ncr(k - 2, childLen());
            ans %= MOD;
            ans *= FA.fact(childLen());
            ans %= MOD;
            for (Node child : adj) {
                ans *= child.calc(k);
                ans %= MOD;
            }
            return ans;
        }
    }
}
