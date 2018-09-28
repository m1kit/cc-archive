package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int deg = in.nextInt(), dis = in.nextInt();
        Direction dir = Direction.values()[(deg + 112) % 3600 / 225];
        int str = STRENGTH.length;
        for (int i = 0; i < STRENGTH.length; i++) {
            if (Math.round(dis / 6.0) <= STRENGTH[i]) {
                str = i;
                break;
            }
        }
        out.print(str == 0 ? 'C' : dir);
        out.print(' ');
        out.println(str);
    }

    enum Direction {
        N,
        NNE,
        NE,
        ENE,
        E,
        ESE,
        SE,
        SSE,
        S,
        SSW,
        SW,
        WSW,
        W,
        WNW,
        NW,
        NNW
    }

    static int[] STRENGTH = {
            2, 15, 33, 54, 79, 107, 138, 171, 207, 244, 284, 326
    };
}
