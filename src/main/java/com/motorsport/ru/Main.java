package com.motorsport.ru;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ReadFileService readFileService = new ReadFileService();
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
        readFileService.readFileAndPutInQueue("file.txt", queue);
        ConcurrentHashMap<String, LinkedBlockingQueue<String>> map = new ConcurrentHashMap<>();

        ExecutorService e = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < queue.size(); i++) {
            e.execute(new Producer(queue, map));
        }
        Thread.currentThread().join();
        System.out.println(map.size());

    }
}