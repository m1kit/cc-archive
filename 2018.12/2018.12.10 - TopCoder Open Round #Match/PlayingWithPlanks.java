package jp.llv.atcoder;

public class PlayingWithPlanks {
    public String canItBeDone(int plankLength, int pieces) {
        long p = (pieces + 1L) * pieces / 2;
        if (p <= plankLength) {
            return "possible";
        } else {
            return "impossible";
        }
    }
}
