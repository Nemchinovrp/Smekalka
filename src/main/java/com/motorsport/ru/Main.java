package com.motorsport.ru;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService e = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        e.execute(new Runnable() {
            public void run() {
                // do one task
            }
        });
    }
}
