package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AWeatherPrediction {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        String s = in.string();
        if (s.equals("Sunny")) {
            out.ans("Cloudy").ln();
        } else if (s.equals("Cloudy")) {
            out.ans("Rainy").ln();
        } else {
            out.ans("Sunny").ln();
        }
    }
}
