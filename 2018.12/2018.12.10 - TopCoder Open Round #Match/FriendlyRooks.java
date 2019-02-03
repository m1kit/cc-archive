package jp.llv.atcoder;

import jp.llv.atcoder.lib.structure.UnionFind;

import java.util.HashSet;
import java.util.Set;

public class FriendlyRooks {
    public int getMinFriendlyColoring(String[] board) {
        int h = board.length;
        int w = board[0].length();
        UnionFind f = new UnionFind(h + w);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (board[i].charAt(j) == 'R') {
                    f.union(i, h + j);
                }
            }
        }
        Set<Integer> g = new HashSet<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (board[i].charAt(j) == 'R') {
                    g.add(f.find(i));
                    g.add(f.find(h + j));
                }
            }
        }
        return g.size();
    }
}
