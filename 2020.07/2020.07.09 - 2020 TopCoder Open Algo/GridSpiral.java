package dev.mikit.atcoder;

public class GridSpiral {
    private static long sum(long x) {
        return (x + 1) * x / 2;
    }

    public long findCell(int _) {
        for (int dv = 7; dv < 100; dv += 2) {
            int d = dv;
            long n = (d - 5) / 2;
            long mine = n * n / 4;

            long x = d / 8;
            long their;
            switch (d % 8) {
                case 1:
                    x = x * 2 - 1;
                    their = x * x;
                    break;
                case 3:
                    x = 2 * x - 1;
                    their = x * x + x;
                    break;
                case 5:
                    //x++;
                    x = 2 * x;
                    their = x * x;
                    break;
                case 7:
                    x = 2 * x;
                    their = x * x + x;
                    break;
                default:
                    return 0;
            }
            if (mine != their) {
                System.out.println(dv + " "+mine+"<=>"+their);
            }
        }
        return 0;
    }
}
