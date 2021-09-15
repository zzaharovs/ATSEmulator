package ru.netology.ats_emulator;

public class UserCall{

    private static final int WORK_TIME = 3000;
    private final String name;

    public UserCall(String name) {

        this.name = name;

    }

    public void doSomething() {

        System.out.printf("%s в работе у %s\n", name, Thread.currentThread().getName());
        try {
            Thread.sleep(WORK_TIME);
        } catch (InterruptedException ignore) {}
        System.out.printf("%s выполнена\n", name);

    }
}
