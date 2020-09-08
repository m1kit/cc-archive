package dev.mikit.atcoder;

import com.fasterxml.jackson.databind.node.BigIntegerNode;
import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

import java.math.BigInteger;
import java.util.*;

public class Cryptopangrams {

    private static final int MOD = (int) 1e9 + 7;
    private static final BigInteger TWO = BigInteger.valueOf(2);

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        String n = in.string();
        int l = in.ints();
        BigInteger[] a = new BigInteger[l];
        for (int i = 0; i < l; i++) {
            a[i] = new BigInteger(in.string());
        }
        BigInteger[] res = new BigInteger[l + 1];

        BigInteger min = TWO, max = new BigInteger("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001");
        while (max.subtract(min).compareTo(BigInteger.ONE) > 0) {
            BigInteger mid = max.add(min).divide(TWO);
            BigInteger pow = mid.pow(2);
            if (pow.compareTo(a[0]) > 0) {
                max = mid;
            } else {
                min = mid;
            }
        }

        int center;
        if (min.pow(2).equals(a[0])) {
            res[0] = min;
            res[1] = min;
            res[2] = a[1].divide(min);
            center = 1;
        } else {
            center = 1;
            while (a[center - 1].equals(a[center])) {
                center++;
            }
            res[center] = a[center - 1].gcd(a[center]);
            res[center - 1] = a[center - 1].divide(res[center]);
            res[center + 1] = a[center].divide(res[center]);
        }
        for (int i = center - 1; i > 0; i--) {
            res[i - 1] = a[i].divide(res[i]);
        }
        for (int i = center + 1; i < l; i++) {
            res[i + 1] = a[i].divide(res[i]);
        }

        List<BigInteger> primes = new ArrayList<>();
        for (int i = 0; i <= l; i++) {
            if (!primes.contains(res[i])) {
                primes.add(res[i]);
            }
        }
        primes.sort(Comparator.naturalOrder());
        if (primes.size() != 26) {
            throw new RuntimeException(primes.toString());
        }

        out.print("Case #" + testNumber + ": ");
        outer:
        for (int i = 0; i <= l; i++) {
            for (int j = 0; j < 26; j++) {
                if (res[i].equals(primes.get(j))) {
                    out.print((char) ('A' + j));
                    continue outer;
                }
            }
        }
        out.ln();
    }
}
