package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class D {

    private static final char[][] D = {
            ".###..#..###.###.#.#.###.###.###.###.###.".toCharArray(),
            ".#.#.##....#...#.#.#.#...#.....#.#.#.#.#.".toCharArray(),
            ".#.#..#..###.###.###.###.###...#.###.###.".toCharArray(),
            ".#.#..#..#.....#...#...#.#.#...#.#.#...#.".toCharArray(),
            ".###.###.###.###...#.###.###...#.###.###.".toCharArray(),
    };

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        char[][] s = in.chars(5);
        for (int i = 0; i < n; i++) {
            int off1 = 4 * i + 1;
            outer: for (int j = 0; j < 10; j++) {
                int off2 = 4 * j + 1;
                for (int y = 0; y < 5; y++) {
                    for (int x = 0; x < 3; x++) {
                        if (s[y][x + off1] != D[y][x + off2]) continue outer;
                    }
                }
                out.print((char) ('0' + j));
                break;
            }
        }
        out.ln();
    }
}
