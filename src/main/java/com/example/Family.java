package com.example;

import java.util.List;

// интерфейс для инъекции зависимости
public interface Family {

    String getFamily();

    // унификация, getKittens не подходит
    int getYoungs();

    List<String> getFood() throws Exception;
}
