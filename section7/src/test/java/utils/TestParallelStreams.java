package utils;

import junit.framework.TestCase;

import static utils.MeasureSumPerf.measureSumPerf;

public class TestParallelStreams extends TestCase {

    public void testSequetialSum(){
        System.out.println(String.format("Sequential sum done in : %s msecs",measureSumPerf(ParallelStreams::sequentialSum,10_000_000)));
        System.out.println(String.format("Sequential sum done in : %s msecs",measureSumPerf(ParallelStreams::iterativeSum,10_000_000)));
        System.out.println(String.format("Sequential sum done in : %s msecs",measureSumPerf(ParallelStreams::parallelSum,10_000_000)));

        System.out.println(String.format("Sequential sum done in : %s msecs",measureSumPerf(ParallelStreams::rangedSum,10_000_000)));
        System.out.println(String.format("Sequential sum done in : %s msecs",measureSumPerf(ParallelStreams::parallelRangedSum,10_000_000)));


        System.out.println(String.format("Sequential sum done in : %s msecs",measureSumPerf(ForkJoinSumCalculator::forkJoinSum,10_000_000)));
    }
}
