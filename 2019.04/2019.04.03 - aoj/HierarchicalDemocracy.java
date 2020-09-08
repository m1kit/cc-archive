package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class HierarchicalDemocracy {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int qNum = in.ints();
        for (int query = 0; query < qNum; query++) {
            String s = in.nextLine();
            Stack<Token> stack = new Stack<>();
            List<Token> list = new ArrayList<>();
            StringBuilder dbg = new StringBuilder();

            int depth = 0;
            long num = 0;
            for (int i = 0; i < s.length(); i++) {
                dbg.append((char) ('0' + depth));
                //System.out.println("q=" + query + "size=" + stack.size());
                char c = s.charAt(i);
                if ('0' <= c && c <= '9') {
                    num *= 10;
                    num += (c - '0');
                } else if (c == '[') {
                    depth++;
                } else {
                    if (num > 0) {
                        stack.push(new Token(depth, (num + 1) / 2));
                        num = 0;
                        depth--;
                    } else {
                        list.clear();
                        while (!stack.isEmpty() && stack.peek().depth == depth + 1) {
                            list.add(stack.pop());
                        }
                        list.sort(Comparator.comparing(t -> t.num));

                        if (list.size() % 2 == 0 || list.size() <= 1) {
                            System.out.println("list=" + list);
                            System.out.println("stack=" + stack);
                            System.out.println("depth=" + depth + " i=" + i);
                            System.out.println(s);
                            System.out.println(dbg);
                            throw new RuntimeException("Inner size is " + list.size());
                        }

                        long ans = 0;
                        for (int j = 0; j < (list.size() + 1) / 2; j++) {
                            ans += list.get(j).num;
                        }

                        stack.push(new Token(depth, ans));
                        depth--;
                    }
                    //System.out.println("NEW TOKEN depth="+stack.peek().depth+" ans="+stack.peek().num);
                }
            }
            if (stack.size() != 1 || stack.peek().depth != 1) {
                System.out.println(stack);
                throw new RuntimeException("i=" + query + " " + stack.size());
            }
            out.ansln(stack.peek().num);
        }
    }

    private static class Token {
        private final int depth;
        private final long num;

        public Token(int depth, long num) {
            this.depth = depth;
            this.num = num;
        }

        @Override
        public String toString() {
            return "Token{" +
                    "depth=" + depth +
                    ", num=" + num +
                    '}';
        }
    }
}
