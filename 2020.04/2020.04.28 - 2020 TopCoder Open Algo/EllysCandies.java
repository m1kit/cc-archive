package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.Arrays;

public class EllysCandies {
    public String getWinner(int[] a) {
        int n = a.length;
        Arrays.sort(a);
        ArrayUtil.reverse(a, 0, n);
        long[] score = new long[2];
        for (int i = 0; i < n; i++) {
            score[i % 2] += a[i];
            for (int j = i + 1; j < n; j++) a[j] += a[i];
        }
        if (score[0] == score[1]) return "Even";
        else if (score[0] > score[1]) return "Elly";
        else return "Kris";
    }
}
