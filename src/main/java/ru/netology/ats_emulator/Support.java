package ru.netology.ats_emulator;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

import static ru.netology.ats_emulator.App.MAX_CALLS_LIMIT;

public class Support implements Runnable {

    private final Queue<UserCall> callsQueue;
    private final AtomicInteger atomicCallsCounter;

    public Support(Queue<UserCall> callsQueue, AtomicInteger atomicCallsCounter)
    {
        this.atomicCallsCounter = atomicCallsCounter;
        this.callsQueue = callsQueue;
    }

    @Override
    public void run() {

        while (true) {

            UserCall call = callsQueue.poll();

            if (call != null) {
                call.doSomething();
                continue;
            }
            if (atomicCallsCounter.get() == MAX_CALLS_LIMIT) {
                System.out.printf("Достигнут лимит на количество звонков\n" +
                        "%s закончил работу\n", Thread.currentThread().getName());
                break;
            }


        }

    }

}