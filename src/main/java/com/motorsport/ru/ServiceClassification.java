package com.motorsport.ru;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

class ServiceClassification {
    private AlphabeticClassifier alphabeticClassifier = new AlphabeticClassifier();
    private NumericalClassifier numericalClassifier = new NumericalClassifier();
    private PunctuationMarksClassifier punctuationMarksClassifier = new PunctuationMarksClassifier();


    void classification(ConcurrentHashMap<String, LinkedBlockingQueue<String>> map, String line) throws InterruptedException {
        if (alphabeticClassifier.classifier(line)) {
            String key = alphabeticClassifier.getClass().getSimpleName();
            putLineToQueue(map, line, key);
        } else if (numericalClassifier.classifier(line)) {
            String key = numericalClassifier.getClass().getSimpleName();
            putLineToQueue(map, line, key);
        } else if (punctuationMarksClassifier.classifier(line)) {
            String key = punctuationMarksClassifier.getClass().getSimpleName();
            putLineToQueue(map, line, key);
        }
    }

    private void putLineToQueue(ConcurrentHashMap<String, LinkedBlockingQueue<String>> map, String line, String key) throws InterruptedException {
        LinkedBlockingQueue<String> blockingQueue = map.get(key);
        if (blockingQueue == null) {
            LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
            queue.put(line);
            map.put(key, queue);
        } else {
            blockingQueue.put(line);
            map.put(key, blockingQueue);
        }
    }
}