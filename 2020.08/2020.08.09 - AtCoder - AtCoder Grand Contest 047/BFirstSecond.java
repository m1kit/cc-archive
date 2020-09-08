package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.lang.reflect.Array;
import java.util.*;

public class BFirstSecond {

    //private static final int MOD = 999999937;
    private static final int[] MOD = {999999937, 1000000007, 1000000009};
    private static final int BASE = 9973;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        //*
        int n = in.ints();
        char[][] s = new char[n][];
        for (int i = 0; i < n; i++) s[i] = in.chars();
        //*/
        /*
        int n = 200000;
        char[][] s = new char[n][];
        for (int i = 0; i < n; i++) {
            s[i] = make(3 + (int) (Math.random() * 7));
        }
        //*/
        /*
        int n = 20000, totallen = 0;
        char[][] s = new char[n][];
        for (int i = 0; i < n; i++) {
            int len = 30 + (int) (Math.random() * 70);
            s[i] = make(len);
            totallen += len;
        }
        System.out.println("TOTAL LEN = " + totallen);
        //*/


        IntroSort.sort(s, Comparator.comparing(a -> a.length));
        List<HashMap<Substring, Integer>> table = new ArrayList<>();
        for (int i = 0; i < 26; i++) table.add(new HashMap<>());
        long ans = 0;
        //long hashing = 0, merging = 0;
        HashSet<Integer> chrs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int m = s[i].length;
            //long t1 = System.currentTimeMillis();

            Substring[] subs = new Substring[m];
            //long hash = 0;
            long[] hash = new long[3];
            for (int j = m - 1; j >= 0; j--) {
                subs[j] = new Substring(j + 1, s[i], (int) hash[0], (int) hash[1], (int) hash[2]);
                for (int k = 0; k < 3; k++) {
                    hash[k] = (hash[k] * BASE + s[i][j]) % MOD[k];
                }
            }

            //long t2 = System.currentTimeMillis();

            chrs.clear();
            for (int j = 0; j < m; j++) {
                chrs.add(s[i][j] - 'a');
                for (int k : chrs) {
                    ans += table.get(k).getOrDefault(subs[j], 0);
                }
            }
            table.get(s[i][0] - 'a').merge(subs[0], 1, Integer::sum);

            /*
            long t3 = System.currentTimeMillis();
            hashing += t2 - t1;
            merging += t3 - t2;*/
        }
        //System.out.println("H" + hashing + " M" + merging);
        //System.out.println(table);
        out.ans(ans).ln();
    }

    private static final class Substring {
        int s, len;
        char[] original;
        int[] hash;

        Substring(int s, char[] original, int... hash) {
            this.s = s;
            this.len = original.length - s;
            this.original = original;
            this.hash = hash;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Substring substring = (Substring) o;
            if (!Arrays.equals(hash, substring.hash)) return false;
            return Arrays.equals(original, s, original.length, substring.original, substring.s, substring.original.length);
        }

        @Override
        public int hashCode() {
            return hash[0];
        }

        @Override
        public String toString() {
            return String.valueOf(original).substring(s);
        }
    }

    private static char[] make(int len) {
        char[] res = new char[len];
        for (int i = 0; i < len; i++) {
            res[i] = (char) ('a' + (int) (Math.random() * 26));
        }
        return res;
    }
}
