package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EElections {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        Station[] stations = new Station[m];
        for (int i = 0; i < m; i++) stations[i] = new Station(i, in.ints(n));

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            final int win = i;
            Arrays.sort(stations, Comparator.comparing(station -> station.polls[win] - station.polls[n - 1]));
            int d = Arrays.stream(stations).mapToInt(station -> station.polls[n - 1] - station.polls[win]).sum();
            List<Integer> res = new ArrayList<>();
            while (d > 0) {
                d -= stations[res.size()].polls[n - 1] - stations[res.size()].polls[win];
                res.add(stations[res.size()].index + 1);
            }
            ans.add(res);
        }

        ans.sort(Comparator.comparing(List::size));
        out.ans(ans.get(0).size()).ln();
        for (int x : ans.get(0)) out.ans(x);
        out.ln();
    }

    private static class Station {
        int index;
        int[] polls;

        Station(int index, int[] polls) {
            this.index = index;
            this.polls = polls;
        }
    }
}
