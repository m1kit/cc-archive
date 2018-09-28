package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int deg = in.nextInt(), dis = in.nextInt();
        if (dis == 0) {
            out.print("C");
        } else {
            int[] le = {0, 113, 338, 563, 788, 1013, 1238, 1463, 1688, 1913, 2138, 2363, 2588, 2813, 3038, 3263, 3488, Integer.MAX_VALUE};
            String[] co = {"N", "NNE", "NE", "ENE", "E", "ESE", "SE", "SSE", "S", "SSW", "SW", "WSW", "W", "WNW", "NW", "NNW", "N"};
            for (int i = 0; i < le.length; i++) {
                if (deg < le[i]) {
                    out.print(co[i - 1]);
                    break;
                }
            }
        }
        out.print(' ');
        int[] kaze = {0, 12,,}
    }
}
