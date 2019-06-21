package org.fundamentals.fp.euler;

import java.math.BigInteger;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * Problem 20: Factorial digit sum
 * n! means n (n 1) ... 3 2 1
 *
 * For example, 10! = 10   9   ...   3   2   1 = 3628800,
 *
 * and the sum of the digits in the number 10! is
 * 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 *
 * Find the sum of the digits in the number 100!
 *
 */
public class EulerProblem20 {

    Function<Long, BigInteger> factorial = limit -> LongStream.iterate(limit, i -> i - 1)
            .limit(limit)
            .mapToObj(BigInteger::valueOf)
            .reduce((n1, n2) -> n1.multiply(n2))
            .get();

    Function<BigInteger, List<String>> toChars = value -> value.toString().chars()
            .mapToObj(c -> String.valueOf((char) c))
            .collect(Collectors.toList());

    Function<List<String>, Long> sum = chars -> chars.stream()
            .mapToLong(s -> Long.valueOf(s))
            .reduce((l1, l2) -> l1 + l2)
            .getAsLong();

    public long javaStreamSolution(long limit) {
        return factorial.andThen(toChars).andThen(sum).apply(limit);
    }
}