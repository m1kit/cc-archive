package jp.llv.atcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class DMakeThemEven {

    /**
     * This method solves the problem.
     *
     * この問題について、いくつかの性質が成立します。
     * - コインの枚数は本質的に重要ではなく、その偶奇のみが重要です。
     * - 操作の順番を交換しても結果としては変わりません。
     *
     * そこで、今回は次のような方針で解答したいと思います。
     * 第k行(k=1,2,3...h-1)について、その行にある奇数個のコインを
     * 直下の行に移動させることで第k行の全てのコインが偶数個ある状態になります。
     * k=1,2,3...h-1に対する操作が終わると奇数個のコインが存在するのは第h行のみです。
     * 後は、l=1,2,3...w-1に対して同じように掃き出すと奇数個のコインが存在するのは
     * (w,h)要素のみです。その要素の偶奇に関わらず、この操作によって奇数個のコインが
     * 最小化されます。
     *
     * @param testNumber テストケース番号
     * @param in         標準入力オブジェクト
     * @param out        標準出力オブジェクト
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        /* == 入力部       開始 == */
        int h = in.nextInt();                           // 盤面の横幅
        int w = in.nextInt();                           // 盤面の縦幅
        List<Operation> operations = new ArrayList<>(); // 解答
        /* == 入力部       開始 == */

        /* == 計算部(1)    開始 == */
        /* vParity[i] = (i + 1,1)要素から(i + 1,y + 1)要素までの和が奇数ならtrue -> コインを下に押し付けます */
        boolean[] vParity = new boolean[w];
        for (int y = 0; y < h - 1; y++) {   // 上から下へ(最終行を除く)
            for (int x = 0; x < w; x++) {   // 左から右へ
                vParity[x] ^= in.nextInt() % 2 == 1; // 偶奇の和はXORで求まります
                if (vParity[x]) { // 奇数ならば下の行にコインを押し付けます
                    operations.add(new Operation(x + 1, y + 1, x + 1, y + 2));
                }
            }
        }
        /* == 計算部(1)    終了 == */


        /* == 計算部(2)    開始 == */
        /* hParity = (x + 1, h)要素が奇数ならtrue -> コインを右に押し付ける */
        boolean hParity = false;
        for (int x = 0; x < w - 1; x++) {   // 左から右へ
            // (x + 1, h)要素の偶奇性は [もともとその場所にあるコイン] XOR [上から押し付けられたコイン]
            //                                                   XOR [左から押し付けられたコイン]
            hParity ^= vParity[x];
            hParity ^= in.nextInt() % 2 == 1;
            if (hParity) { // 奇数ならば右の列にコインを押し付けます
                operations.add(new Operation(x + 1, h, x + 2, h));
            }
        }
        /* == 計算部(2)    終了 == */


        /* == 出力部    開始 == */
        out.println(operations.size());
        for (Operation operation : operations) {
            out.print(operation.y1);
            out.print(' ');
            out.print(operation.x1);
            out.print(' ');
            out.print(operation.y2);
            out.print(' ');
            out.println(operation.x2);
        }
        /* == 出力部    終了 == */
    }

    /**
     * This class represents an operation described in the problem.
     */
    public static class Operation {
        int x1;
        int y1;
        int x2;
        int y2;

        public Operation(int a, int b, int c, int d) {
            this.x1 = a;
            this.y1 = b;
            this.x2 = c;
            this.y2 = d;
        }
    }
}
