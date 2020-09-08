package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;
import dev.mikit.atcoder.lib.structure.segmenttree.IntSegmentTree;

import java.util.Comparator;
import java.util.TreeSet;

public class DIrrigation {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int past = in.ints(), m = in.ints(), q = in.ints();
        City[] cities = new City[m];
        Query[] queries = new Query[q];
        for (int i = 0; i < m; i++) cities[i] = new City(i, 0);
        for (int i = 0; i < past; i++) cities[in.ints() - 1].count++;
        for (int i = 0; i < q; i++) queries[i] = new Query(i, in.longs() - past);
        IntroSort.sort(cities, Comparator.comparing(city -> city.count));
        IntroSort.sort(queries, Comparator.comparing(query -> query.k));

        IntSegmentTree st = new IntSegmentTree(new long[m], Long::sum, 0, (x, u) -> u);

        long offset = 0;
        int last = 0, cur = 0;
        for (int i = 0; i < m; i++) {
            long count = i * (long) (cities[i].count - last);
            while (cur < q && queries[cur].k <= offset + count) {
                int idx = (int) ((queries[cur].k - offset - 1) % i);

                int min = -1, max = m - 1;
                while (max - min > 1) {
                    int mid = (min + max + 1) / 2;
                    if (st.query(0, mid + 1) >= idx + 1) {
                        max = mid;
                    } else {
                        min = mid;
                    }
                }

                queries[cur++].answer = max;
            }
            offset += count;
            last = cities[i].count;
            st.update(cities[i].index, 1);
        }
        while (cur < q) {
            queries[cur].answer = (int) ((queries[cur].k - offset - 1) % m);
            cur++;
        }

        IntroSort.sort(queries, Comparator.comparing(query -> query.index));
        for (int i = 0; i < q; i++) out.ans(queries[i].answer + 1).ln();
    }

    private static class City {
        int index, count;

        public City(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }

    private static class Query {
        int index, answer = -1;
        long k;

        public Query(int index, long k) {
            this.index = index;
            this.k = k;
        }
    }
}
