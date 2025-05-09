package com.example;

import java.util.List;

public class Lion {

    Family family;

    boolean hasMane;

    public Lion(Family family, String sex) throws Exception {

        this.family = family;

        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самей или самка");
        }
    }

    public String getFamily() {
        return family.getFamily();
    }

    public int getKittens() {
        return family.getYoungs();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception { return family.getFood(); }
}
