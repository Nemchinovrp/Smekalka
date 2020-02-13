package com.motorsport.ru;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class PunctuationMarksClassifierTest {
    private PunctuationMarksClassifier pMClassifier = new PunctuationMarksClassifier();

    @Test
    public void testPositive() {
        assertTrue(pMClassifier.classifier("раз, три"));
    }

    @Test
    public void testNegative() {
        assertFalse(pMClassifier.classifier("раз5, три"));
    }
}