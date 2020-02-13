package com.motorsport.ru;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {
    private File fileToRead;
    private ConcurrentHashMap<String, BlockingQueue<String>> map;

    public Producer(File filePath, ConcurrentHashMap<String, BlockingQueue<String>> map) {
        fileToRead = filePath;
        this.map = map;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileToRead));
            String line;
            while ((line = reader.readLine()) != null) {
//                    queue.put(line);
                System.out.println(Thread.currentThread().getName() + " added \"" + line + "\" to queue, queue size: ");
            }
            System.out.println(Thread.currentThread().getName() + " finished");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}