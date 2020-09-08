package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.structure.Dice;

import java.util.*;

public class B {

    private static final Dice.Roll[] ROLLS = {Dice.Roll.FORWARD, Dice.Roll.BACKWARD, Dice.Roll.RIGHT, Dice.Roll.LEFT};
    private static final int[] DC = {0, 0, 1, -1};
    private static final int[] DR = {1, -1, 0, 0};

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        int h = in.ints() + 2, w = in.ints() + 2;
        char[][] s = new char[h][];
        s[0] = s[h - 1] = new char[w];
        Arrays.fill(s[0], '#');
        for (int i = 1; i < h - 1; i++) s[i] = ("#" + in.string() + "#").toCharArray();
        if (h == 3 && w == 3) {
            out.yesln();
            return;
        }

        EnumMap<Dice.Face, Character> map = new EnumMap<>(Dice.Face.class);
        map.put(Dice.Face.TOP, '1');
        map.put(Dice.Face.FRONT, '2');
        map.put(Dice.Face.RIGHT, '3');
        map.put(Dice.Face.LEFT, '4');
        map.put(Dice.Face.BACK, '5');
        map.put(Dice.Face.BOTTOM, '6');


        Set<State> visited = new HashSet<>();
        Queue<State> q = new ArrayDeque<>();
        q.offer(new State(1, 1, new Dice<>(map)));
        while (!q.isEmpty()) {
            State now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now.r + DR[i], nc = now.c + DC[i];
                Dice<Character> roll = new Dice<>(now.roll);
                roll.apply(ROLLS[i]);
                if (s[nr][nc] != roll.get(Dice.Face.BOTTOM)) continue;
                if (nr == h - 2 && nc == w - 2) {
                    out.yesln();
                    return;
                }
                State next = new State(nr, nc, roll);
                if (!visited.contains(next)) {
                    visited.add(next);
                    q.offer(next);
                }
            }
        }
        out.noln();
    }

    private static class State {
        int r, c;
        Dice<Character> roll;

        State(int r, int c, Dice<Character> roll) {
            this.r = r;
            this.c = c;
            this.roll = roll;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            if (r != state.r) return false;
            if (c != state.c) return false;
            return Objects.equals(roll, state.roll);
        }

        @Override
        public int hashCode() {
            int result = r;
            result = 31 * result + c;
            result = 31 * result + (roll != null ? roll.hashCode() : 0);
            return result;
        }
    }
}
