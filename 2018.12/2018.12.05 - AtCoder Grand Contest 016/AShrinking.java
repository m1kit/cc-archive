package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class AShrinking {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        String s = in.string();
        int[] n = new int[26];
        for (char c : s.toCharArray()) {
            n[c - 'a']++;
        }
        int min = 100000;
        for (char c = 'a'; c <= 'z'; c++) {
            String t = s;
            int ans = 0;
            while (t.chars().distinct().count() > 1) {
                char[] ns = new char[t.length() - 1];
                for (int i = 0; i < ns.length; i++) {
                    ns[i] = t.charAt(i) == c || t.charAt(i + 1) == c ? c : t.charAt(i);
                }
                t = String.valueOf(ns);
                ans++;
            }
            min = Math.min(min, ans);
        }
        out.println(min);
    }
}
