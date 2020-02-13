package com.motorsport.ru;

public class NumericalClassifier implements Сlassifier {

    @Override
    public boolean classifier(String input) {
        return input.matches("[а-я0-9-.?!,:]+( [а-я0-9-.?!,:]+)*");
    }
}
