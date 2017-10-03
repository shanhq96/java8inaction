package utils;

import java.util.function.Function;

public class MeasureSumPerf {

    public static long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println(String.format("Result : %s", sum));
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }

}
