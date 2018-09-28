package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class BUnionFind {

    int n, q;
    int[] tree;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        n = in.nextInt();
        q = in.nextInt();
        tree = new int[n];
        for (int i = 0; i < n; i++) {
            tree[i] = i;
        }
        for (int i = 0; i < q; i++) {
            if (in.nextInt() == 0) {
                tree[in.nextInt()] = group(in.nextInt());
            } else {
                out.println(group(in.nextInt()) == group(in.nextInt()) ? "Yes" : "No");
            }
        }
    }

    int group(int i) {
        int n = tree[i];
        if (n == i) {
            return i;
        }
        return tree[i] = group(tree[i]);
    }
}
