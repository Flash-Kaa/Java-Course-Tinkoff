package edu.hw2;

public class Task4 {
    private Task4() {
    }

    private static final int COUNT_STACK_TRACE_AFTER_CALLING_IN_THREAD = 2;
    private static final int INDEX_STACK_TRACE_WITH_EXCEPTION = 0;

    public static CallingInfo getCallingInfo(Exception exception) {
        StackTraceElement curTrace;

        if (exception == null) {
            curTrace = Thread.currentThread().getStackTrace()[COUNT_STACK_TRACE_AFTER_CALLING_IN_THREAD];
        } else {
            curTrace = exception.getStackTrace()[INDEX_STACK_TRACE_WITH_EXCEPTION];
        }

        return new CallingInfo(curTrace.getClassName(), curTrace.getMethodName());
    }
}
