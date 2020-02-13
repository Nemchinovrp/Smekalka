package com.motorsport.ru;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class AlphabeticClassifierTest {
    private AlphabeticClassifier alphabeticClassifier = new AlphabeticClassifier();

    @Test
    public void testPositive() {
        assertTrue(alphabeticClassifier.classifier("ывсы иавпи мывм вмвав"));
    }

    @Test
    public void testNegative() {
        assertFalse(alphabeticClassifier.classifier("ывсы иавпи мывм вмв78"));
    }
}