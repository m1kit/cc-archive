package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class DGridComponents {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a = in.nextInt() - 1, b = in.nextInt() - 1;
        System.out.println("100 100");
        for (int y = 0; y < 49; y++) {
            for (int x = 0; x < 100; x++) {
                if (b > 0 && x % 2 == 0 && y % 2 == 0) {
                    System.out.print('#');
                    b--;
                } else {
                    System.out.print('.');
                }
            }
            System.out.println();
        }
        for (int i = 0; i < 100; i++) {
            System.out.print('.');
        }
        System.out.println();
        for (int i = 0; i < 100; i++) {
            System.out.print('#');
        }
        System.out.println();
        for (int y = 51; y < 100; y++) {
            for (int x = 0; x < 100; x++) {
                if (a > 0 && x % 2 == 0 && y % 2 == 0) {
                    System.out.print('.');
                    a--;
                } else {
                    System.out.print('#');
                }
            }
            System.out.println();
        }
    }
}
