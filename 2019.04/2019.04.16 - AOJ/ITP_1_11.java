package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.structure.Dice;

import java.util.EnumMap;
import java.util.Map;

public class ITP_1_11 {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        Map<Dice.Face, Integer> init = new EnumMap<>(Dice.Face.class);
        init.put(Dice.Face.TOP, in.ints());
        init.put(Dice.Face.FRONT, in.ints());
        init.put(Dice.Face.RIGHT, in.ints());
        init.put(Dice.Face.LEFT, in.ints());
        init.put(Dice.Face.BACK, in.ints());
        init.put(Dice.Face.BOTTOM, in.ints());
        Dice<Integer> dice = new Dice<>(init);
        String s = in.string();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'N':
                    dice.apply(Dice.Roll.BACKWARD);
                    break;
                case 'S':
                    dice.apply(Dice.Roll.FORWARD);
                    break;
                case 'E':
                    dice.apply(Dice.Roll.RIGHT);
                    break;
                case 'W':
                    dice.apply(Dice.Roll.LEFT);
                    break;
            }
        }
        out.ansln(dice.get(Dice.Face.TOP));
    }
}
