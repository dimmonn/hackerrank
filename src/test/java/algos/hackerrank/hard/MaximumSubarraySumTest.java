package algos.hackerrank.hard;

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
    List<long[]> testData = new ArrayList<>();

    @Before
    public void setUp() throws Exception {

        List<String[]> _strings = Files.lines(Paths.get("src/main/resources/maxSum.txt"))
                .map(e -> e.split(" ")).collect(Collectors.toList());
        for (String[] string : _strings) {
            List<String> _tmp = new ArrayList<>(Arrays.asList(string));
            _tmp.remove(0);


            long[] longs = _tmp.stream().mapToLong(Long::parseLong).toArray();
            testData.add(longs);
        }
    }

    @Test
    public void maximumSumTest() {

        for (int i = 0; i < testData.size(); i++) {
            long mod = testData.get(0)[0];
            System.out.println(maximumSum(testData.get(i), mod));
        }
    }
}