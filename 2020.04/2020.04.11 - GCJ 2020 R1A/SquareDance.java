package dev.mikit.atcoder;

import com.sun.org.apache.regexp.internal.RE;
import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

import java.util.*;

public class SquareDance {

    private static final int[] DX = {1, 0, -1, 0};
    private static final int[] DY = {0, -1, 0, 1};
    private static final int[] REV = {2, 3, 0, 1};

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setCaseLabel(LightWriter.CaseLabel.GCJ);
        int testCases = in.ints();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            out.cases(testCase);
            int h = in.ints(), w = in.ints();
            long ans = 0, sum = 0;
            Queue<Node> q = new ArrayDeque<>(h * w), r = new ArrayDeque<>(h * w);
            Node[][] nodes = new Node[h][w];

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    nodes[i][j] = new Node(in.ints());
                    q.offer(nodes[i][j]);
                    sum += nodes[i][j].power;
                }
            }
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    for (int k = 0; k < 4; k++) {
                        int y = i + DY[k], x = j + DX[k];
                        if (0 <= x && x < w && 0 <= y && y < h) {
                            nodes[i][j].neighbor[k] = nodes[y][x];
                        }
                    }
                }
            }

            boolean cont = true;
            int uniq = 0;
            while (cont) {
                cont = false;
                uniq++;
                ans += sum;
                while (!q.isEmpty()) {
                    Node node = q.poll();
                    if (!node.wins()) {
                        node.destroyed = true;
                        cont = true;
                        r.offer(node);
                        sum -= node.power;
                    }
                }
                while (!r.isEmpty()) {
                    Node node = r.poll();
                    node.rebuild();
                    for (int i = 0; i < 4; i++) {
                        if (node.neighbor[i] != null && node.neighbor[i].t != uniq && !node.neighbor[i].destroyed) {
                            q.offer(node.neighbor[i]);
                            node.neighbor[i].t = uniq;
                        }
                    }
                }
            }
            out.ans(ans).ln();
        }
    }

    private static class Node {
        final int power;
        Node[] neighbor = new Node[4];
        boolean destroyed = false;
        int t = 0;

        Node(int power) {
            this.power = power;
        }

        boolean wins() {
            int count = 0, sum = 0;
            for (int i = 0; i < 4; i++) {
                if (neighbor[i] != null) {
                    count++;
                    sum += neighbor[i].power;
                }
            }
            return power * count >= sum;
        }

        void rebuild() {
            if (!destroyed) return;
            for (int i = 0; i < 4; i++) {
                if (neighbor[i] != null) neighbor[i].neighbor[REV[i]] = neighbor[REV[i]];
            }
        }
    }
}
