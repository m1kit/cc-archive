package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DHandstand {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), k = in.ints();
        String s = in.string();
        if (s.matches("^1+$")) {
            out.ansln(s.length());
            return;
        }

        Stack<Token> stack = new Stack<>();
        stack.push(new Token(s.charAt(0) == '1', 1));
        for (int i = 1; i < n; i++) {
            if ((s.charAt(i) == '1') == stack.peek().v) {
                stack.peek().l++;
            } else {
                stack.push(new Token(s.charAt(i) == '1', 1));
            }
        }

        List<Segment> segs = new ArrayList<>();
        Token prev = new Token(true, 0);
        while (!stack.isEmpty()) {
            Token t = stack.pop();
            if (t.v) {
                prev = t;
            } else {
                if (!stack.isEmpty()) {
                    segs.add(new Segment(prev.l, t.l, stack.peek().l));
                } else {
                    segs.add(new Segment(prev.l, t.l, 0));
                }
            }
        }

        int l = 0;
        int v = segs.get(0).sum();
        int ans = segs.get(0).sum();
        //System.out.println(segs.get(0));
        for (int r = 1; r < segs.size(); r++) {
            if (r - l + 1 > k) {
                v -= segs.get(l).left;
                v -= segs.get(l).middle;
                l++;
            }
            v += segs.get(r).middle;
            v += segs.get(r).right;
            ans = Math.max(ans, v);
        }
        out.ansln(ans);
    }

    private static class Token {
        boolean v;
        int l;

        public Token(boolean v, int l) {
            this.v = v;
            this.l = l;
        }
    }

    private static class Segment {
        int left, middle, right;

        public Segment(int left, int middle, int right) {
            this.left = left;
            this.middle = middle;
            this.right = right;
        }

        int sum() {
            return left + middle + right;
        }
    }
}
