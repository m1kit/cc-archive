package jp.llv.atcoder;

import jp.llv.atcoder.lib.graph.shortestpath.BellmanFord;

import java.util.Scanner;
import java.io.PrintWriter;

public class DScoreAttack {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        BellmanFord bf = new BellmanFord(n);
        for (int i = 0; i < m; i++) {
            bf.addEdge(in.nextInt() - 1, in.nextInt() - 1, -in.nextInt());
        }
        try {
            out.println(-bf.shortestPath(0, n - 1));
        } catch(RuntimeException ex) {
            out.println("inf");
        }
    }
}
