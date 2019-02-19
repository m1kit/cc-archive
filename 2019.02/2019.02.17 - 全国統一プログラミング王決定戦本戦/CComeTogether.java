package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;

public class CComeTogether {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        int h = in.ints(), w = in.ints();
        int k = in.ints();
        long siz = w * (long) h;

        int[] ch = new int[h], cw = new int[w];
        Arrays.fill(ch, w);
        Arrays.fill(cw, h);
        for (int i = 0; i < k; i++) {
            ch[in.ints() - 1]--;
            cw[in.ints() - 1]--;
        }
        long hsum = IntStream.of(ch).sum(), csum = IntStream.of(cw).sum();

        long[] hinc = new long[h], hdec = new long[h];
        long tmp = 0, count = 0;
        for (int i = 0; i < h; i++) {
            hinc[i] = tmp;
            count += ch[i];
            tmp += count;
        }
        tmp = 0;count = 0;
        for (int i = h - 1; i >= 0; i--) {
            hdec[i] = tmp;
            count += ch[i];
            tmp += count;
        }
        long hmin = Long.MAX_VALUE;
        for (int i = 0; i < h; i++) {
            hmin = Math.min(hmin, hinc[i] + hdec[i]);
        }

        long[] winc = new long[w], wdec = new long[w];
        tmp = 0; count = 0;
        for (int i = 0; i < w; i++) {
            winc[i] = tmp;
            count += cw[i];
            tmp += count;
        }
        tmp = 0; count = 0;
        for (int i = w - 1; i >= 0; i--) {
            wdec[i] = tmp;
            count += cw[i];
            tmp += count;
        }

        long cmin = Long.MAX_VALUE;
        for (int i = 0; i < w; i++) {
            cmin = Math.min(cmin, winc[i] + wdec[i]);
        }

        //System.out.println(Arrays.toString(hinc));
        //System.out.println(Arrays.toString(hdec));
        //System.out.println(Arrays.toString(winc));
        //System.out.println(Arrays.toString(wdec));
        //System.out.println(hmin);
        out.ansln(cmin + hmin);
    }
}
