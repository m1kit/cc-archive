package jp.llv.atcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class D {

    static int w;
    static int h;
    static int n;
    static int x[];
    static int y[];
    Map<Area, Integer> dp = new HashMap<>();

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        /* 1. INPUT */
        w = in.nextInt();
        h = in.nextInt();
        n = in.nextInt();
        x = new int[n];
        y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }

        /* 2. CALC */
        out.println(dfs(new Area(0, 0, w + 1, h + 1)));
    }

    /* :thinking_face: */
    private int dfs(Area area) {
        // 計算したことがあったら即返却します: dpなのでそれはそう
        if (dp.containsKey(area)) {
            return dp.get(area);
        }

        boolean containsMachine = false;
        int max = 0;

        // 嫌なんだけど全部のマシーンを見ます...嫌だけど
        for (int i = 0; i < n; i++) {
            if (!area.contains(x[i], y[i])) {
                continue;
            }
            containsMachine = true;
            int g = 0;
            if (0 < x[i]) {
                if (0 < y[i]) {
                    g += dfs(new Area(area.x1, area.y1, x[i], y[i]));
                }
                if (y[i] < h) {
                    g += dfs(new Area(area.x1, y[i], x[i], area.y2));
                }
            }
            if (x[i] < w) {
                if (0 < y[i]) {
                    g += dfs(new Area(x[i], area.y1, area.x2, y[i]));
                }
                if (y[i] < h) {
                    g += dfs(new Area(x[i], y[i], area.x2, area.y2));
                }
            }
            max = Math.max(max, g);
        }

        // 機械があるので、その場所に関わらず以下の金塊を採掘できる
        if (containsMachine) {
            max += area.y2 - area.y1 + area.x2 - area.x1 - 3;
        }

        dp.put(area, max);
        return max;
    }

    /**
     * 閉領域を表現するクラスです。
     */
    static class Area {
        int x1, y1, x2, y2;

        Area(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        boolean contains(int x, int y) {
            return x1 < x && x < x2 && y1 < y && y < y2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Area area = (Area) o;
            return x1 == area.x1 && y1 == area.y1 && x2 == area.x2 && y2 == area.y2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x1, y1, x2, y2);
        }

        @Override
        public String toString() {
            return String.format("(%d,%d),(%d,%d)", x1, y1, x2, y2);
        }
    }
}
