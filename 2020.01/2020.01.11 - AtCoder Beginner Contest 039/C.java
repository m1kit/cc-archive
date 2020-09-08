package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;

public class C {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.ans(new String[]{
                "Si", null,
                "La", null,
                "So", null,
                "Fa",
                "Mi", null,
                "Re", null,
                "Do",
                "Si", null,
                "La", null,
                "So", null,
                "Fa",
                "Mi", null,
                "Re", null,
                "Do",
        }[in.string().indexOf("WWBWBWW")]).ln();
    }
}
