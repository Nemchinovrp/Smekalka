package com.motorsport.ru;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceClassification {
    private AlphabeticClassifier alphabeticClassifier = new AlphabeticClassifier();
    private NumericalClassifier numericalClassifier = new NumericalClassifier();
    private PunctuationMarksClassifier punctuationMarksClassifier = new PunctuationMarksClassifier();


    public ConcurrentHashMap<String, BlockingQueue<String>> classification(ConcurrentHashMap<String, BlockingQueue<String>> map, String line) throws InterruptedException {
        if (alphabeticClassifier.classifier(line)) {
            String key = alphabeticClassifier.getClass().getSimpleName();
            BlockingQueue<String> blockingQueue = map.get(key);
            blockingQueue.put(line);
            map.put(key, blockingQueue);
        } else if (numericalClassifier.classifier(line)) {
            String key = numericalClassifier.getClass().getSimpleName();
            BlockingQueue<String> blockingQueue = map.get(key);
            blockingQueue.put(line);
            map.put(key, blockingQueue);
        } else if (punctuationMarksClassifier.classifier(line)) {
            String key = punctuationMarksClassifier.getClass().getSimpleName();
            BlockingQueue<String> blockingQueue = map.get(key);
            blockingQueue.put(line);
            map.put(key, blockingQueue);
        }
        return map;
    }
}
