package utils;

import junit.framework.TestCase;
import org.junit.Test;

import static utils.Prime.partitionPrimes;
import static utils.Prime.partitionPrimesWithCustomCollector;

public class TestPrime extends TestCase {

    @Test
    public void testPartitionPrimes(){
        partitionPrimes(100).forEach((k,v)->{System.out.println(String.format("%s -> %s",k,v));});
        partitionPrimesWithCustomCollector(100).forEach((k,v)->{System.out.println(String.format("%s -> %s",k,v));});
    }

    @Test
    public void testCollectorHarness(){
       long fastest = Long.MAX_VALUE;
       for (int i=0;i<10;i++){
           long start = System.nanoTime();
           partitionPrimes(1_000_000);
           long duration = (System.nanoTime() - start)/1_000_000;
           if (duration < fastest) fastest = duration;
       }
       System.out.println(String.format("Fastest execution done in %s msecs",fastest));

    }
}
//Fastest execution done in 455514198 msecs
//