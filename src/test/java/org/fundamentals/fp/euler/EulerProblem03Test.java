package org.fundamentals.fp.euler;

import org.assertj.core.api.Assertions;
import org.fundamentals.fp.euler.utils.BaseEulerProblemTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EulerProblem03Test extends BaseEulerProblemTest {

    @Test
    public void given_primeFactors_when_13195_then_expectedResultsTest(){

        EulerProblem03 problem = new EulerProblem03();

        assertThat(problem.JavaSolution(13195L)).isEqualTo(29);
        assertThat(problem.JavaSolution(600851475143L)).isEqualTo(euler.getAnswerToLong(3));

    }

    @Test
    public void given_primeFactorsStream_when_13195_then_expectedResultsTest(){

        EulerProblem03 problem = new EulerProblem03();

        assertThat(problem.JavaStreamSolution(13195L)).isEqualTo(29);
        assertThat(problem.JavaStreamSolution(600851475143L)).isEqualTo(euler.getAnswerToLong(3));

    }

    @Test
    public void given_VAVRSolution_when_13195_then_expectedResultsTest(){

        EulerProblem03 problem = new EulerProblem03();

        assertThat(problem.VAVRSolution(13195L)).isEqualTo(29);
        assertThat(problem.VAVRSolution(600851475143L)).isEqualTo(euler.getAnswerToLong(3));
    }

    @Disabled
    @Test
    public void given_ReactorSolutionProblem_when_sumEven_then_returnExpectedValueTest() {

        EulerProblem03 problem = new EulerProblem03();

        StepVerifier
                .create(problem.ReactorSolution(13195L))
                .expectNext(29L)
                .expectComplete()
                .verify();

        StepVerifier
                .create(problem.ReactorSolution(600851475143L))
                .expectNext(euler.getAnswerToLong(3))
                .expectComplete()
                .verify();

    }

    @Disabled
    @Test
    public void given_KotlinSolution_when_13195_then_expectedResultsTest(){

        EulerProblem03 problem = new EulerProblem03();

        assertThat(problem.KotlinSolution(13195L)).isEqualTo(29);
        assertThat(problem.KotlinSolution(600851475143L)).isEqualTo(euler.getAnswerToLong(3));
    }

    @Disabled
    @Test
    public void given_RxJavaSolution_whenExecute_then_expectedResultTest() {

        EulerProblem03 problem = new EulerProblem03();

        Assertions.assertThat(problem.RxJavaSolution(13195L).test()
                .assertComplete()
                .assertNoErrors()
                .assertValueCount(1)
                .values().get(0)).isEqualTo(29L);

        Assertions.assertThat(problem.RxJavaSolution(600851475143L).test()
                .assertComplete()
                .assertNoErrors()
                .assertValueCount(1)
                .values().get(0)).isEqualTo(euler.getAnswerToLong(3));
    }

}