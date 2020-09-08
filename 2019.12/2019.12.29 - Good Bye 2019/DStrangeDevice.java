package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DStrangeDevice {

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Interactor intr = new Interactor(in, out);
        //Interactor intr = new FakeInteractor(in, out, 5, 1, 2, 0, 1, 9, 3, 8, 7, 5, 4);
        int n = intr.n, k = intr.k;

        int[] query = IntStream.range(0, k).toArray();
        Answer first = intr.query(query);
        query[first.index] = k;
        Answer second = intr.query(query);

        if (first.value > second.value) {
            Answer t = first;
            first = second;
            second = t;
        }

        int ans = 0;
        for (int i = 0; i <= k; i++) {
            if (i == first.index || i == second.index) continue;

            int cur = 0;
            for (int j = 0; j <= k; j++) {
                if (i == j) continue;
                query[cur++] = j;
            }
            if (intr.query(query).index != first.index) ans++;
        }
        intr.answer(ans + 1);
    }

    private static class Interactor {
        private final int n, k;
        private final LightScanner in;
        private final LightWriter out;
        private final List<Integer> nat, rev;

        public Interactor(LightScanner in, LightWriter out, int n, int k) {
            this.n = n;
            this.k = k;
            this.in = in;
            this.out = out;
            nat = IntStream.range(0, n).boxed().collect(Collectors.toList());
            Collections.shuffle(nat);
            rev = Arrays.asList(new Integer[n]);
            for (int i = 0; i < n; i++) rev.set(nat.get(i), i);
        }

        public Interactor(LightScanner in, LightWriter out) {
            this(in, out, in.ints(), in.ints());
        }

        Answer query(int... q) {
            out.ans('?');
            for (int x : q) out.ans(nat.get(x) + 1);
            out.ln().flush();
            return new Answer(rev.get(in.ints() - 1), in.ints());
        }

        void answer(int m) {
            out.ans('!').ans(m).ln().flush();
        }
    }

    private class FakeInteractor extends Interactor {

        private final int[] a;
        private final int m;

        public FakeInteractor(LightScanner in, LightWriter out, int k, int m, int... a) {
            super(in, out, a.length, k);
            this.a = a;
            this.m = m;
        }

        Answer query(int... q) {
            List<Answer> answers = new ArrayList<>();
            for (int i = 0; i < super.k; i++) answers.add(new Answer(q[i], a[q[i]]));
            answers.sort(Comparator.comparing(answer -> answer.value));
            return answers.get(m - 1);
        }

        void answer(int m) {
            super.out.ans(m == this.m);
        }

    }

    private static class Answer {
        int index;
        int value;

        public Answer(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
