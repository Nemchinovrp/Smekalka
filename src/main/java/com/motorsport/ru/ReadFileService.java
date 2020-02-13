package com.motorsport.ru;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.LinkedBlockingQueue;

public class ReadFileService {
    public static void main(String[] args) throws IOException, InterruptedException {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
        new ReadFileService().readFileAndPutInQueue("file.txt", queue);
        System.out.println(queue.size());
        queue.stream().forEach(System.out::println);

    }

    public LinkedBlockingQueue readFileAndPutInQueue(String fileName, LinkedBlockingQueue<String> queue) throws IOException, InterruptedException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        assert resource != null;
        File file = new File(resource.getFile());
        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                queue.put(line);
            }
        }
        return queue;
    }
}
