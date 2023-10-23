package edu.hw2;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FourthTaskTest {
    private FourthTaskTest() {
    }

    @Test
    void testIfHaventException() {
        var curClass = getClass().getName();
        var method = "getResultAndCompareWithExpected";

        getResultAndCompareWithExpected(null, curClass, method);
    }

    @Test
    void testCallingWithException() {
        var curClass = getClass().getName();
        var curMethod = "testCallingWithException";
        var exception = new NullPointerException();

        getResultAndCompareWithExpected(exception, curClass, curMethod);
    }

    @Test
    void testHaveExceptionInOtherMethod() {
        var curClass = getClass().getName();

        try {
            getException();
        } catch (Exception e) {
            getResultAndCompareWithExpected(e, curClass, "getException");
        }

        try {
            callMethodWithException();
        } catch (Exception e) {
            getResultAndCompareWithExpected(e, curClass, "getException");
        }

        try {
            new TestClass().getExceptionInNewClass();
        } catch (Exception e) {
            getResultAndCompareWithExpected(e, TestClass.class.getName(), "getExceptionInNewClass");
        }
    }

    private void getException() {
        throw new RuntimeException();
    }

    private void callMethodWithException() {
        getException();
    }

    private void getResultAndCompareWithExpected(
        Exception exception,
        String expectedClassName,
        String expectedMethodName
    ) {
        var res = Task4.getCallingInfo(exception);

        assertThat(res.className()).isEqualTo(expectedClassName);
        assertThat(res.methodName()).isEqualTo(expectedMethodName);
    }

    class TestClass {
        public void getExceptionInNewClass() {
            throw new RuntimeException();
        }
    }
}
