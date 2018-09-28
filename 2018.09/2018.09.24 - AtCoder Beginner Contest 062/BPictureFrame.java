package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class BPictureFrame {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int h = in.nextInt(), w = in.nextInt();
        IntStream.range(0, w + 2).forEach(x -> out.print('#'));
        out.println();
        for (int i = 0; i < h; i++) {
            out.print('#');
            out.print(in.next());
            out.println('#');
        }
        IntStream.range(0, w + 2).forEach(x -> out.print('#'));
        out.println();
    }
}
