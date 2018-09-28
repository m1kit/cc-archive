package jp.llv.atcoder;

import java.util.HashSet;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Set;

public class CABlandYard {

    private static Node[] nodes;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        nodes = new Node[n];
        String s = in.next();
        for (int i = 0; i < n; i++) {
            nodes[i].a = s.charAt(i) == 'A';
        }
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            nodes[a].nodes.add(nodes[b]);
            nodes[b].nodes.add(nodes[a]);
        }

    }

    private static void dfs(Set<Loop> loops) {

    }

    private static class Node {
        Set<Node> nodes = new HashSet<>();
        boolean a;
        boolean s;
    }

    private static class Loop {
        Set<Node> nodes;
    }
}
