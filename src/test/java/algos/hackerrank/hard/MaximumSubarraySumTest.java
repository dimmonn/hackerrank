package algos.hackerrank.hard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static algos.hackerrank.hard.MaximumSubarraySum.maximumSum;

public class MaximumSubarraySumTest {
    private List<long[]> testData = new ArrayList<>();
    private long[] answers;

    @Before
    public void setUp() throws Exception {

        List<String[]> _strings = Files.lines(Paths.get("src/main/resources/maxSum.txt"))
                .map(e -> e.split(" ")).collect(Collectors.toList());
        answers = Files.lines(Paths.get("src/main/resources/1000Ktest.txt"))
                .mapToLong(Long::parseLong).toArray();
        for (String[] string : _strings) {
            List<String> _tmp = new ArrayList<>(Arrays.asList(string));
            long[] longs = _tmp.stream().mapToLong(Long::parseLong).toArray();
            testData.add(longs);
        }
    }

    @Test
    public void maximumSumTest() {

        for (int i = 0; i < testData.size(); i++) {
            long mod = testData.get(i)[0];
            long[] longs = Arrays.copyOfRange(testData.get(i), 1, testData.get(i).length );
            Assert.assertEquals("iteration failed "+i,answers[i], maximumSum(longs, mod));
        }
    }
}