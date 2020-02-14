package com.motorsport.ru;

import java.io.IOException;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ReadFileService readFileService = new ReadFileService();
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
        readFileService.readFileAndPutInQueue("file.txt", queue);
        ConcurrentHashMap<String, LinkedBlockingQueue<String>> map = new ConcurrentHashMap<>();

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < queue.size(); i++) {
            executorService.execute(new Producer(queue, map));
        }
        System.out.println(map.size());
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
        System.out.println(map.size());
    }
}