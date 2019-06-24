package org.fundamentals.fp.euler;

import org.fundamentals.fp.euler.utils.BaseEulerProblemTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EulerProblem26Test extends BaseEulerProblemTest {

    @Disabled
    @Test
    public void given_problem_when_javaStreamSolution_then_expectedResultsTest(){

        EulerProblem26 problem = new EulerProblem26();

        assertThat(problem.javaStreamSolution(10L)).isEqualTo(12);
        //assertThat(problem.javaStreamSolution(1000L)).isEqualTo(euler.getAnswerToLong(26));
    }

}