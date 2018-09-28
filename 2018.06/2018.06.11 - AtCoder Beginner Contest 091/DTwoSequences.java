package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class DTwoSequences {

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int k;
        {
            k = 3;
        }
        System.out.println(k);


        int result = 1;
        for (int i = 1; i <= 10; i++) {
            result = result * i;
        }
        System.out.println(result);

        int i = 3;
        if (i > 2) {
            System.out.println("i > 2");
        }
    }
}
