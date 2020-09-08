package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.math.PrimeTable;

import java.util.HashSet;
import java.util.Set;

public class PrimeSubstrings {
    private static String[] TABLE = {
            "",
            "2",
            "11", //
            "113",
            "1193", //
            "11939",
            "193939",
            "9991313", //
    };

    public String construct(int n, int l) {
        int p = 13133399;
        int len = 0, t = p, pow = 1;
        while (t > 0) {
            len++;
            pow *= 10;
            t /= 10;
        }
        PrimeTable table = new PrimeTable(1);
        int count = len;
        for (int i = 0; i < len; i++) {
            if (!table.isPrime(p) || (p * 10) / pow == 0) count--;
            p *= 10;
            p += p / pow;
            p %= pow;
        }
        System.out.println(p + "(" + len + "): " + count);
        return "";
    }
}
