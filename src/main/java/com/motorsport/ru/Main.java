package com.motorsport.ru;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ReadFileService readFileService = new ReadFileService();
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
        readFileService.readFileAndPutInQueue("file.txt", queue);


        ExecutorService e = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        e.execute(new Runnable() {
            public void run() {
                // do one task
            }
        });
    }
}
