package com.motorsport.ru;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class Producer implements Runnable {
    private ServiceClassification serviceClassification = new ServiceClassification();
    private ConcurrentHashMap<String, LinkedBlockingQueue<String>> map;
    private LinkedBlockingQueue<String> queue;

    public Producer(LinkedBlockingQueue<String> queue, ConcurrentHashMap<String, LinkedBlockingQueue<String>> map) {
        this.queue = queue;
        this.map = map;
    }

    @Override
    public void run() {
        try {
            serviceClassification.classification(map, queue.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " finished");
    }
}