package utils;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static utils.CountWordsIteratively.countWordsIteratively;
import static utils.WordCounter.countWords;

public class TestCountWords extends TestCase {
    final String SENTENCE = " Nel    mezzo del cammin  di nostra vita "+
            "mi  ritrovai in una  selva oscura" +
            " che la dritta via era   smarrita ";



    @Test
    public void testCountWordsIteratively(){

        System.out.println(String.format("Found %d words",countWordsIteratively(SENTENCE)));
    }

    @Test
    public void testCountWords(){
        Stream<Character> stream = IntStream.range(0,SENTENCE.length())
                .mapToObj(SENTENCE::charAt);
        System.out.println(String.format("Found %d words",countWords(stream.parallel())));

        Spliterator<Character> spliterator = new WordCounterSpliterator(SENTENCE);
        Stream<Character> stream1 = StreamSupport.stream(spliterator,true);
        System.out.println(String.format("Found %d words",countWords(stream1.parallel())));
    }

}
