package jp.llv.atcoder;

import java.util.*;
import java.io.PrintWriter;

public class DRecording {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;
    private static final int CHANNELS = 30;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        in.nextInt();
        Program[] t = new Program[n];
        for (int i = 0; i < n; i++) {
            t[i] = new Program(in.nextInt(), in.nextInt(), in.nextInt() - 1);
        }
        Arrays.sort(t, Comparator.comparing(p -> p.start));

        List<Program> programs = new ArrayList<>();
        Program[] last = new Program[CHANNELS];
        for (Program p : t) {
            if (last[p.channel] != null) {
                if (p.start - last[p.channel].end > 0) {
                    programs.add(last[p.channel]);
                    last[p.channel] = p;
                } else {
                    last[p.channel] = new Program(last[p.channel].start, p.end, p.channel);
                }
            } else {
                last[p.channel] = p;
            }
        }
        Arrays.stream(last).filter(Objects::nonNull).forEach(programs::add);
        programs.sort(Comparator.comparing(p -> p.start));

        List<Integer> recorders = new ArrayList<>();
        for (Program p : programs) {
            Iterator<Integer> it = recorders.iterator();
            while (it.hasNext()) {
                if (it.next() < p.start) {
                    it.remove();
                    break;
                }
            }
            recorders.add(p.end);
        }
        out.println(recorders.size());
    }

    private static class Program {
        int channel;
        int start;
        int end;

        public Program(int start, int end, int channel) {
            this.channel = channel;
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Program{" +
                    "channel=" + channel +
                    ", start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
