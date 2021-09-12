package ru.netology.ats_emulator;


import java.util.Queue;

public class ManyAngryUsers implements Runnable {

    private static final int MAX_COUNTER_CALLS = 10;
    private static final int TIMEOUT_USER_CALL = 500;
    private int counterCalls;
    private Queue<Runnable> userCalls;

    public ManyAngryUsers(Queue<Runnable> userCalls) {
        this.userCalls = userCalls;
    }

    @Override
    public void run() {

        while (true) {

            if (counterCalls == MAX_COUNTER_CALLS) {
                break;
            }

            userCalls.add(new UserCall("Задача № " + (++counterCalls)));
            System.out.printf("Добавлена %d задача \n", counterCalls);

            try {
                Thread.sleep(TIMEOUT_USER_CALL);
            } catch (InterruptedException ex) {
                break;
            }


        }
    }
}
