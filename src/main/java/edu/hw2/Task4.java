package edu.hw2;

public class Task4 {
    private Task4() {
    }

    private static final int COUNT_STACK_TRACE_AFTER_CALLING = 2;

    // При чём тут Throwable#getStackTrace? В Throwable вообще нет статичных полей, как я понял, да и это же класс.. я решил задачу, как понял..
    public static CallingInfo getCallingInfo() { // first calling
        var stackTrace = Thread.currentThread().getStackTrace(); // second calling
        var curStackTraceElement = stackTrace[COUNT_STACK_TRACE_AFTER_CALLING];
        return new CallingInfo(curStackTraceElement.getClassLoaderName(), curStackTraceElement.getMethodName());
    }
}
