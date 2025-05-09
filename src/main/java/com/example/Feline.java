package com.example;

import java.util.List;

public class Feline extends Animal implements Predator, Family {

    @Override
    public List<String> eatMeat() throws Exception {
        return getFood("Хищник");
    }

    @Override
    public String getFamily() {
        return "Кошачьи";
    }

    @Override
    public int getYoungs() {
        return getKittens(1);
    }

    @Override
    public List<String> getFood() throws Exception {
        return getFood("Хищник");
    }

    public int getKittens(int kittensCount) {
        return kittensCount;
    }

}
