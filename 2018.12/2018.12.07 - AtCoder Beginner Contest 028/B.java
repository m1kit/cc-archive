package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;

import java.io.PrintWriter;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class B {

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        String s = in.string();
        out.println(IntStream.rangeClosed('A', 'F')
                .mapToLong(t -> s.chars().filter(x -> x == t).count())
                .mapToObj(Long::toString)
                .collect(Collectors.joining(" ")));
    }
}

