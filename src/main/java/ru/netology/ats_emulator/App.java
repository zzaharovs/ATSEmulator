package ru.netology.ats_emulator;

import java.time.Duration;
import java.time.Instant;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class App {


    public static void main(String[] args) throws InterruptedException {




        Queue<Runnable> userCalls = new LinkedBlockingQueue<>();

        Thread t1 = new Thread(new ManyAngryUsers(userCalls));
        t1.start();


        for (int i = 0; i < 4; i++) {
            new Thread(new Support(userCalls), "Оператор поддержки " + (i + 1)).start();
        }

    }
}
