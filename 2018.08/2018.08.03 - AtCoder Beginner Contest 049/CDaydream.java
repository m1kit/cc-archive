package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class CDaydream {

    public static final String[] STRINGS = {"esare", "resare", "maerd", "remaerd"};

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        out.println(
                in.next()
                        .replace("eraser", "/")
                        .replace("erase", "/")
                        .replace("dreamer", "/")
                        .replace("dream", "/")
                        .replace("/", "")
                        .isEmpty() ? "YES" : "NO"
        );
    }
}
