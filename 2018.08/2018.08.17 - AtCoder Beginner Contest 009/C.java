package jp.llv.atcoder;

import java.util.*;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class C {

    private static String s;
    private static Map<Key, String> dp = new HashMap<>();

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        dp.clear();
        int n = in.nextInt(), k = in.nextInt();
        s = in.next();
        char[] array = s.toCharArray();
        Arrays.sort(array);
        out.println(calc(new Key(k, String.valueOf(array))));
        System.out.println(dp);
    }

    private String calc(Key key) {
        if (key.k < 0) {
            return null;
        } else if (key.s.length() == 0) {
            return "";
        } else if (dp.containsKey(key)) {
            return dp.get(key);
        }

        // POSSIBILITY PREDICTION
        int[] count = new int[26];
        for (int i = s.length() - key.s.length(); i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < key.s.length(); i++) {
            count[key.s.charAt(i) - 'a']--;
        }
        int dif = IntStream.of(count).map(Math::abs).sum();
        if (dif > key.k * 2) {
            dp.put(key, null);
            return null;
        }

        for (int i = 0; i < key.s.length(); i++) {
            int k = s.charAt(s.length() - key.s.length()) == key.s.charAt(i) ? key.k : key.k - 1;
            String res = calc(new Key(k, key.s.substring(0, i) + key.s.substring(i + 1)));
            if (res != null) {
                String v = key.s.charAt(i) + res;
                dp.put(key, v);
                return v;
            }
        }

        dp.put(key, null);
        return null;
    }

    private static class Key {

        private final int k;
        private final String s;

        public Key(int k, String s) {
            this.k = k;
            this.s = s;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return k == key.k &&
                    Objects.equals(s, key.s);
        }

        @Override
        public int hashCode() {
            return Objects.hash(k, s);
        }

        @Override
        public String toString() {
            return s + ":" + k;
        }
    }
}
