package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class D {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int h = in.ints(), w = in.ints(), a = in.ints(), b = in.ints();
        String[] m = new String[h];
        for (int i = 0; i < h; i++) {
            m[i] = in.string();
        }
        int flag = 0b11;
        long ans = 0;
        long sumA = 0;
        long sumB = 0;
        for (int i = 0; i < h / 2; i++) {
            for (int j = 0; j < w / 2; j++) {
                int p = 0;
                p |= m[i        ].charAt(j        ) == 'S' ? 0b0001 : 0;
                p |= m[i        ].charAt(w - j - 1) == 'S' ? 0b0010 : 0;
                p |= m[h - i - 1].charAt(j        ) == 'S' ? 0b0100 : 0;
                p |= m[h - i - 1].charAt(w - j - 1) == 'S' ? 0b1000 : 0;
                switch (p) {
                    case 0b0000:
                        break;
                    case 0b1111:
                        ans += Math.max(a, b) + a + b;
                        break;
                    case 0b0101:
                    case 0b1010:
                        sumA += a;
                        flag &= 0b10;
                        break;
                    case 0b1100:
                    case 0b0011:
                        sumB += b;
                        flag &= 0b01;
                        break;
                    case 0b1110:
                    case 0b1101:
                    case 0b1011:
                    case 0b0111:
                        sumA += a;
                        sumB += b;
                    default:
                        flag &= 0b00;
                }
            }
        }
        //System.out.println(Integer.toBinaryString(flag));
        switch (flag) {
            case 0b00:
                ans += a + b;
                break;
            case 0b10:
                ans += b;
                break;
            case 0b01:
                ans += a;
                break;
        }
        out.println(ans + Math.max(sumA, sumB));
    }
}
