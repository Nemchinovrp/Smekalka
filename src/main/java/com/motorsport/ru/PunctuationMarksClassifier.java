package com.motorsport.ru;

public class PunctuationMarksClassifier implements Сlassifier {

    @Override
    public boolean classifier(String input) {
        return input.matches("[а-я-.?!,:]+( [а-я-.?!,:]+)*");
    }
}