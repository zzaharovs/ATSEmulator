package ru.netology.ats_emulator;


import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

import static ru.netology.ats_emulator.App.MAX_CALLS_LIMIT;

public class ManyAngryUsers implements Runnable {

    private static final int TIMEOUT_USER_CALL = 500;
    private final Queue<UserCall> userCalls;
    private final AtomicInteger atomicCallsCounter;

    public ManyAngryUsers(Queue<UserCall> userCalls, AtomicInteger atomicCallsCounter)
    {
        this.atomicCallsCounter = atomicCallsCounter;
        this.userCalls = userCalls;
    }

    @Override
    public void run() {

        while (true) {

            if (atomicCallsCounter.get() == MAX_CALLS_LIMIT) {
                break;
            }

            userCalls.add(new UserCall("Задача № " + (atomicCallsCounter.incrementAndGet())));
            System.out.printf("Добавлена %d задача \n", atomicCallsCounter.get());

            try {
                Thread.sleep(TIMEOUT_USER_CALL);
            } catch (InterruptedException ex) {
                break;
            }


        }
    }
}
