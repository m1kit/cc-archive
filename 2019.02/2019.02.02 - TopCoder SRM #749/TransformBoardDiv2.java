package jp.llv.atcoder;

import java.util.Stack;

public class TransformBoardDiv2 {

    private static boolean[] searched;

    public int[] getOperations(String[] start, String[] target) {
        int h = start.length, w = start[0].length();
        int si = intnize(start, h, w), ti = intnize(target, h, w);
        Stack<Integer> ans = new Stack<>();
        searched = new boolean[1 << (h * w)];
        if (!calc(ans, si, ti, h, w)) {
            return new int[]{-1};
        }
        int i = ans.size();
        int[] res = new int[ans.size()];
        while (i > 0) {
            res[--i] = ans.pop();
        }
        return res;
    }

    public static int encodeop(int r1, int c1, int r2, int c2) {
        return r1 * 1000000 + c1 * 10000 + r2 * 100 + c2;
    }

    public static int intnize(String[] board, int h, int w) {
        int res = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int s = i * w + j;
                if (board[i].charAt(j) == '#') {
                    res |= (1 << s);
                }
            }
        }
        return res;
    }

    public static boolean isBlack(int board, int r, int c, int h, int w) {
        int i = r * w + c;
        return ((board >> i) & 1) == 1;
    }

    public static int invert(int board, int r, int c, int h, int w) {
        int i = r * w + c;
        return board ^ (1 << i);
    }

    public static boolean calc(Stack<Integer> res, int board, int target, int h, int w) {
        if (board == target) {
            return true;
        } else if (searched[board]) {
            return false;
        }
        searched[board] = true;

        //System.out.println("NOW: "+Integer.toBinaryString(board));

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean b = isBlack(board, i, j, h, w), t = isBlack(target, i, j, h, w);
                //System.out.println("@("+i+","+j+"), b="+b);
                if (!b) {
                    continue;
                }
                int nb = invert(board, i, j, h, w);
                for (int k = j + 1; k < w; k++) {//yoko
                    int nb2 = invert(nb, i, k, h, w);
                    res.push(encodeop(i, j, i, k));
                    if (calc(res, nb2, target, h, w)) {
                        return true;
                    }
                    res.pop();
                }
                for (int k = i + 1; k < h; k++) {//tate
                    int nb2 = invert(nb, k, j, h, w);
                    res.push(encodeop(i, j, k, j));
                    if (calc(res, nb2, target, h, w)) {
                        return true;
                    }
                    res.pop();
                }
            }
        }

        return false;
    }
}
