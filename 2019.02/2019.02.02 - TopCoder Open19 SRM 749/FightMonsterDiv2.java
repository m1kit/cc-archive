package jp.llv.atcoder;

public class FightMonsterDiv2 {
    public long damageDealt(long attack, long level, long duration) {
        long ans = 0;
        long bonus = 0;
        for (int i = 0; i < duration; i++) {
            ans += attack + bonus;
            bonus += level * attack / 100;
        }
        return ans;
    }
}
