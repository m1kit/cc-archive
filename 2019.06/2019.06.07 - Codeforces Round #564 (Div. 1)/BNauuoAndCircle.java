package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.Factorial;
import dev.mikit.atcoder.lib.math.mod.ModMath;

import java.util.ArrayList;
import java.util.List;

public class BNauuoAndCircle {

    private static final int MOD = 998244353;
    private static final ModMath mod = new ModMath(MOD);
    private static final Factorial fact = mod.getFactorial(200_001);

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = in.ints() - 1, b = in.ints() - 1;
            nodes[a].neg.add(nodes[b]);
            nodes[b].neg.add(nodes[a]);
        }
        long ans = nodes[0].dfs(null);
        out.ans((ans * n) % MOD).ln();
    }

    private static class Node {
        List<Node> neg = new ArrayList<>();
        long dfs(Node parent) {
            if (parent == null) {
                long ans = fact.fact(neg.size());
                for (Node next : neg) {
                    ans *= next.dfs(this);
                    ans %= MOD;
                }
                return ans;
            }

            //if (neg.size() == 1) return 1;

            long ans = (fact.fact(neg.size() - 1) * neg.size()) % MOD;
            for (Node next : neg) {
                if (next == parent) continue;
                ans *= next.dfs(this);
                ans %= MOD;
            }
            return ans;
        }
    }
}
