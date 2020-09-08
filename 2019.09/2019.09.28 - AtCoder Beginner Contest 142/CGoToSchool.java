package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.Comparator;

public class CGoToSchool {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            students[i] = new Student(i + 1, in.ints());
        }
        IntroSort.sort(students, Comparator.comparing(student -> student.order));
        for (int i = 0; i < n; i++) {
            out.ans(students[i].index);
        }
        out.ln();
    }

    private static class Student {
        int index, order;

         Student(int index, int order) {
            this.index = index;
            this.order = order;
        }
    }
}
