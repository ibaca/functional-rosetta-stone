package org.fundamentals.fp.euler;

import io.reactivex.Single;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.LongStream;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static java.util.stream.Collectors.toList;

/**
 * https://projecteuler.net/problem=3
 *
 * Original:
 *
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 *
 * Scenario 13195
 *
 * Given primeFactor
 * When 13195
 * Then 29 [5, 7, 13, 29]
 *
 * Scenario 600851475143
 *
 * Given primeFactor
 * When 600851475143
 * Then ?
 */
public class EulerProblem03 {

    private List<Long> primeFactors(long limit) {

        List<Long> listOfFactors = new ArrayList<>();
        for (long i = 2; i <= limit; i++) {
            while (limit % i == 0) {
                listOfFactors.add(i);
                limit /= i;
            }
        }
        return listOfFactors;
    }

    public long JavaSolution(long number) {

        List<Long> factorList = primeFactors(number);
        return primeFactors(number).get(factorList.size() -1);
    }

    LongStream factors(long lastFactor, long num) {

        return LongStream.rangeClosed(lastFactor, (long) Math.sqrt(num))
                .filter(x -> num % x == 0)
                .mapToObj(x -> LongStream.concat(LongStream.of(x), factors(x, num / x)))
                .findFirst()
                .orElse(LongStream.of(num));
    }

    public long JavaStreamSolution(long limit) {

        return factors(2, limit)
                .mapToObj(l -> Long.valueOf(l))
                .collect(toList()).stream()
                .sorted(Comparator.reverseOrder()).findFirst().get();
    }

    public long VAVRSolution(long limit) {

        return PrimeNumbers.primeFactors(limit).max().get();
    }

    Flux<Long> reactorFactors(int lastFactor, long limit) {

        return Flux.range(0, (int) Math.round(Math.sqrt(limit)))
                .filter(x -> limit % x == 0)
                .map(x -> Flux.concat(Flux.just(x), reactorFactors(x, limit / x)))
                .map(x -> Long.valueOf(x.toString()))
                .sort()
                .take(1);

    }

    public Mono<Long> ReactorSolution(long limit) {

        reactorFactors(2, limit).subscribe(System.out::println);

        return Mono.just(0L);
    }

    public Long KotlinSolution(long limit) {

        return EulerProblem03Kt.KotlinSolution03(limit);
    }

    public Single<Long> RxJavaSolution(long l) {

        return Single.just(0l);
    }
}
