package ru.netology.ats_emulator;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class App {


    public static final int MAX_CALLS_LIMIT = 40;

    public static void main(String[] args){


        AtomicInteger atomicCallCounter = new AtomicInteger(0);
        Queue<UserCall> userCalls = new LinkedBlockingQueue<>();

        Thread t1 = new Thread(new ManyAngryUsers(userCalls, atomicCallCounter));
        t1.start();


        for (int i = 0; i < 4; i++) {
            new Thread(new Support(userCalls, atomicCallCounter), "Оператор поддержки " + (i + 1)).start();
        }

    }
}
