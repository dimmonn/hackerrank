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
import static org.junit.Assert.*;

public class MaximumSubarraySumTest {
    List<String[]> _strings;
    @Before
    public void setUp() throws Exception {

        _strings = Files.lines(Paths.get("src/main/resources/maxSum.txt"))
                .map(e -> e.split(" ")).collect(Collectors.toList());


    }

    @Test
    public void maximumSumTest() {
        for (String[] string : _strings) {
            List<String> _tmp = new ArrayList<>(Arrays.asList(string));
            _tmp.remove(0);
            Long mod = Long.parseLong(_tmp.remove(0));

            long[] longs = _tmp.stream().mapToLong(Long::parseLong).toArray();
            System.out.println(maximumSum(longs, mod));

        }
    }
}