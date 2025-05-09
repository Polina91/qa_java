package com.example;


// инъекция зависимости
public class IndependentLion {
    public static void main(String[] args) throws Exception {
        Family feline = new Feline();
        Lion lion = new Lion(feline, "Самец");
        System.out.println(lion.getFamily());
        System.out.println(lion.getFood());
        System.out.println(lion.getKittens());
        System.out.println(lion.doesHaveMane());
    }
}
