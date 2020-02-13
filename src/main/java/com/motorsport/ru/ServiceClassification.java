package com.motorsport.ru;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class ServiceClassification {
    private AlphabeticClassifier alphabeticClassifier = new AlphabeticClassifier();
    private NumericalClassifier numericalClassifier = new NumericalClassifier();
    private PunctuationMarksClassifier punctuationMarksClassifier = new PunctuationMarksClassifier();


    public ConcurrentHashMap<String, LinkedBlockingQueue<String>> classification(ConcurrentHashMap<String, LinkedBlockingQueue<String>> map, String line) throws InterruptedException {
        if (alphabeticClassifier.classifier(line)) {
            String key = alphabeticClassifier.getClass().getSimpleName();
            LinkedBlockingQueue<String> blockingQueue = map.get(key);
            blockingQueue.put(line);
            map.put(key, blockingQueue);
        } else if (numericalClassifier.classifier(line)) {
            String key = numericalClassifier.getClass().getSimpleName();
            LinkedBlockingQueue<String> blockingQueue = map.get(key);
            blockingQueue.put(line);
            map.put(key, blockingQueue);
        } else if (punctuationMarksClassifier.classifier(line)) {
            String key = punctuationMarksClassifier.getClass().getSimpleName();
            LinkedBlockingQueue<String> blockingQueue = map.get(key);
            blockingQueue.put(line);
            map.put(key, blockingQueue);
        }
        return map;
    }
}
