package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.structure.persistence.PersistentArray;

import java.util.BitSet;
import java.util.stream.IntStream;

public class DPersistentBookcase {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints(), queries = in.ints();
        BitSet[] sets = IntStream.range(0, n).mapToObj(x -> new BitSet(m)).toArray(BitSet[]::new);
        PersistentArray<BitSet> array = new PersistentArray<>(sets);
        int[] ans = new int[queries + 1];
        int count = 0;
        for (int q = 0; q < queries; q++) {
            switch(in.ints()) {
                case 1: {
                    int i = in.ints() - 1, j = in.ints() - 1;
                    BitSet set = (BitSet) array.get(i).clone();
                    if (!set.get(j)) {
                        count++;
                    }
                    set.set(j);
                    array.set(i, set);
                }
                break;
                case 2: {
                    int i = in.ints() - 1, j = in.ints() - 1;
                    BitSet set = (BitSet) array.get(i).clone();
                    if (set.get(j)) {
                        count--;
                    }
                    set.clear(j);
                    array.set(i, set);
                }
                break;
                case 3: {
                    int i = in.ints() - 1;
                    BitSet set = (BitSet) array.get(i).clone();
                    count += m - 2 * set.cardinality();
                    set.flip(0, m);
                    array.set(i, set);
                }
                break;
                case 4: {
                    int k = in.ints();
                    count = ans[k];
                    array.set(k);
                }
                break;
            }
            ans[q + 1] = count;
            out.ansln(count);
        }
    }
}
