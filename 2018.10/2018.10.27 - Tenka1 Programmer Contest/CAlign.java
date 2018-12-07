package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class CAlign {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.ints());
        }
        list.sort(Comparator.naturalOrder());
        LinkedList<Integer> list1 = (LinkedList<Integer>) list.clone();

        LinkedList<Integer> ans0 = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            switch (i % 4) {
                case 0:
                    ans0.addFirst(list.pollFirst());
                    break;
                case 1:
                    ans0.addLast(list.pollFirst());
                    break;
                case 2:
                    ans0.addFirst(list.pollLast());
                    break;
                case 3:
                    ans0.addLast(list.pollLast());
                    break;
            }
        }


        LinkedList<Integer> ans1 = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            switch (i % 4) {
                case 2:
                    ans1.addFirst(list1.pollFirst());
                    break;
                case 3:
                    ans1.addLast(list1.pollFirst());
                    break;
                case 0:
                    ans1.addFirst(list1.pollLast());
                    break;
                case 1:
                    ans1.addLast(list1.pollLast());
                    break;
            }
        }

        Iterator<Integer> it0 = ans0.iterator();
        Iterator<Integer> it1 = ans1.iterator();
        long v0 = 0, v1 = 0;
        int last0 = it0.next();
        int last1 = it1.next();
        while (it0.hasNext() && it1.hasNext()) {
            int a0 = it0.next(), a1 = it1.next();
            v0 += Math.abs(a0 - last0);
            v1 += Math.abs(a1 - last1);
            last0 = a0;
            last1 = a1;
        }
        if (v0 < 0 || v1 < 0) {
            throw new RuntimeException();
        }
        out.println(Math.max(v0, v1));
    }
}
