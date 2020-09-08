package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.seqence.Parser;

public class J {
    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.ans(new Parser<String>(in.string()) {
            @Override
            public String parse() {
                StringBuilder res = new StringBuilder();
                while (true) {
                    if (Character.isAlphabetic(now())) {
                        res.append(now());
                        next();
                    } else if (now() == '(') {
                        next();
                        String s = parse();
                        res.append(s).append(new StringBuilder(s).reverse().toString());
                        next();
                    } else break;
                }
                return res.toString();
            }
        }.parse()).ln();
    }
}
