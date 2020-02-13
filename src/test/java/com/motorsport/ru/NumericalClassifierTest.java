package com.motorsport.ru;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class NumericalClassifierTest {
    private NumericalClassifier numericalClassifier = new NumericalClassifier();

    @Test
    public void classifierPositive() {
        assertTrue(numericalClassifier.classifier("раз5, три"));
    }

    @Test
    public void classifierNegative() {
        assertFalse(numericalClassifier.classifier("раз5,* три"));
    }

    @Test
    public void classifierNegativeTwo() {
        assertFalse(numericalClassifier.classifier("***"));
    }
}
