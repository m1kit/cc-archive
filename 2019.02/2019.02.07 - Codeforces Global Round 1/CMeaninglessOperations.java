package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.math.IntMath;

import java.util.HashMap;
import java.util.Map;

public class CMeaninglessOperations {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        int q = in.ints();

        Map<Long, Long> dp = new HashMap<>();
        dp.put(33554431L, 1082401L);
        dp.put(16777215L, 5592405L);
        dp.put(8388607L, 178481L);
        dp.put(4194303L, 1398101L);
        dp.put(15L, 5L);
        dp.put(2097151L, 299593L);
        dp.put(1048575L, 349525L);
        dp.put(262143L, 87381L);
        dp.put(4095L, 1365L);
        dp.put(65535L, 21845L);
        dp.put(32767L, 4681L);
        dp.put(16383L, 5461L);
        dp.put(2047L, 89L);
        dp.put(1023L, 341L);
        dp.put(511L, 73L);
        dp.put(255L, 85L);
        dp.put(63L, 21L);

        for (int query = 0; query < q; query++) {
            long a = in.longs();
            if (dp.containsKey(a)) {
                out.ans(dp.get(a)).ln();
                continue;
            }
            long r = 0;
            for (int i = 1; i <= a; i <<= 1) {
                if ((a & i) == 0) {
                    r |= i;
                }
            }
            if (r != 0) {
                out.ans(a ^ r).ln();
            } else {
                out.ans(1).ln();
            }
        }
    }
}
