package ru.netology.ats_emulator;

import java.util.Queue;

public class Support implements Runnable {

    private Queue<Runnable> callsQueue;
    private int noNewCallsCounter;
    private static int MAX_COUNT_NO_CALLS_INTERATIION = 3;
    private static final long WAIT_CALL = 1000;

    public Support(Queue<Runnable> callsQueue) {
        this.callsQueue = callsQueue;
    }

    @Override
    public void run() {

        while (true) {

            Runnable call = callsQueue.poll();

            if (call != null) {
                call.run();
                continue;
            }

            try {
                noNewCallsCounter++;
                Thread.sleep(WAIT_CALL);
            } catch (InterruptedException exception) {
                continue;
            }

            if (noNewCallsCounter == MAX_COUNT_NO_CALLS_INTERATIION) {
                System.out.printf("Звонки не поступали продолжительное время\n" +
                        "%s закончил работу\n", Thread.currentThread().getName());
                break;
            }


        }

    }

}