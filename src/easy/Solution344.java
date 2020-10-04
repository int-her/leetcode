package easy;

import main.Solution;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution344 extends Solution {

    @Override
    public void test() {
        var input = Arrays.asList(
                new char[]{'a', 'b', 'c', 'd'},
                new char[]{'a', 'b', 'c', 'd', 'e'}
        );
        input.forEach(this::reverseString);
        input.forEach(System.out::println);
    }

    public void reverseString(char[] s) {
        IntStream.range(0, s.length / 2).forEach(i -> {
            var temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        });
    }
}