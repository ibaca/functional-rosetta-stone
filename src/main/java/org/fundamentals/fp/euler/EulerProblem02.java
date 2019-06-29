package org.fundamentals.fp.euler;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import reactor.core.publisher.Mono;
import reactor.math.MathFlux;

/**
 * https://projecteuler.net/problem=2
 *
 * Original:
 *
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms.
 * By starting with 1 and 2, the first 10 terms will be:
 *
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 *
 * By considering the terms in the Fibonacci sequence whose values
 * do not exceed four million, find the sum of the even-valued terms.
 *
 * Further information about a Fibonacci serie:
 * https://en.wikipedia.org/wiki/Fibonacci_number
 *
 * Scenario 100:
 *
 * Given a Fibonacci sequence:
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89
 *
 * When execute sumEven method
 * Then find the sum of the even-valued terms
 *
 */
@Solved
public class EulerProblem02 {

    public Long JavaSolution(long limit) {

        long sum = 0L;
        for (long number : Utils.Java.fibonacci(limit)) {

            if ((number % 2) == 0) {
                sum += number;
            }
        }

        return sum;
    }

    Predicate<Long> isEven = number -> (number % 2) == 0;

    public Long JavaStreamSolution(long limit) {

        return Utils.JavaStreams.fibonacci(limit)
                .filter(isEven)
                .collect(Collectors.summingLong(Long::longValue));
    }

    public Long VAVRSolution(long limit) {

        return Utils.VAVR.fibonacci(limit)
                .filter(isEven)
                .reduce(Long::sum);
    }

    public Mono<Long> ReactorSolution(long limit) {

        return MathFlux.sumLong(Utils.Reactor.fibonacci(limit)
                .filter(isEven));
    }

    public Long KotlinSolution(long limit) {

        return EulerProblem02Kt.KotlinSolution02(limit);
    }
}
