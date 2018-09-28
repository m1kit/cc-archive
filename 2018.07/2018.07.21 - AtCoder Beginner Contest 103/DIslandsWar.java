package jp.llv.atcoder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.function.Function;

public class DIslandsWar {

    /* https://beta.atcoder.jp/contests/abc103/submissions/2886748 */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        in.nextInt(); //>> NUL
        int m = in.nextInt();
        Tuple[] operations = new Tuple[2 * m];
        for (int i = 0; i < m; i++) {
            int a = in.nextInt(), b = in.nextInt();
            operations[i * 2] = new Tuple(a, Type.START, i);
            operations[i * 2 + 1] = new Tuple(b, Type.END, i);
        }
        Arrays.sort(operations,
                Comparator.comparingInt(Tuple::getIslandID)
                        .thenComparing(Tuple::getType, Comparator.reverseOrder())
        );

        int res = 0;
        boolean[] deleted = new boolean[m];
        int left = 0;
        for (int i = 0; i < 2 * m; i++) {
            if (operations[i].type == Type.END && !deleted[operations[i].i]) {
                res++;
                for (; left <= i; left++) {
                    if (operations[left].type == Type.START) {
                        deleted[operations[left].i] = true;
                    }
                }
            }
        }
        out.println(res);
    }

    static class Tuple {
        int pos;
        Type type;
        int i;

        Tuple(int pos, Type type, int i) {
            this.pos = pos;
            this.type = type;
            this.i = i;
        }

        int getIslandID() {
            return pos;
        }

        Type getType() {
            return type;
        }

        int getIndex() {
            return i;
        }
    }

    enum Type {
        START,
        END,
    }
}
