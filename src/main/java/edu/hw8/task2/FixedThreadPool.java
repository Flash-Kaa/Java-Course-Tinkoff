package edu.hw8.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FixedThreadPool {
    private final BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
    private final List<Thread> threads = new ArrayList<>();

    public FixedThreadPool(int maxThreadCount) {
        for (int i = 0; i < maxThreadCount; i++) {
            Thread thread = new Thread(new TaskWorker());
            threads.add(thread);
            thread.start();
        }
    }

    public void execute(Runnable runnable) {
        queue.add(runnable);
    }

    public void close() {
        for (Thread t : threads) {
            t.interrupt();
        }
    }

    private final class TaskWorker implements Runnable {
        @Override public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    queue.take().run();
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
