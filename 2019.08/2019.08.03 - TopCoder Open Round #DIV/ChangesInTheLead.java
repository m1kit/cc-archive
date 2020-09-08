package dev.mikit.atcoder;

public class ChangesInTheLead {
    private static final int MOD = 1_000_000_007;

    public int count(int s0, int s1, int change) {
        int lose = Math.min(s0, s1), win = Math.max(s0, s1);
        int coeff = s0 == s1 && s0 > 0 ? 2 : 1;

        long[][] table = new long[301][301];
        // table[winning][losing] := number of scoring patterns without change
        table[0][0] = 1;
        for (int i = 0; i <= 300; i++) {
            for (int j = 0; j <= i; j++) {
                if (i > 0) table[i][j] += table[i - 1][j];
                if (j > 0) table[i][j] += table[i][j - 1];
                table[i][j] %= MOD;
            }
        }
        if (change == 0) {
            return (int) (coeff * table[win][lose] % MOD);
        } else {
            //table[0][0] = 0;
        }

        long[][] dp = new long[change + 1][301];
        dp[0][0] = 1;
        for (int i = 0; i < change; i++) {
            for (int base = 0; base <= 300; base++) {
                for (int earn = 1; base + earn <= 300; earn++) {
                    dp[i + 1][base + earn] += (table[earn][earn] * dp[i][base]) % MOD;
                    dp[i + 1][base + earn] %= MOD;
                }
            }
        }

        long ans = 0;
        for (int i = 0; i <= lose; i++) {
            ans += dp[change][i] * table[win - i][lose - i] % MOD;
            ans %= MOD;
        }
        return (int) (ans * coeff % MOD);
    }
}
