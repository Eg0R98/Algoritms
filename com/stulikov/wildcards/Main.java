package com.stulikov.wildcards;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals  = new ArrayList<>();
        List<Pet> pets = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();
        List<ScottishFold> scottishFolds = new ArrayList<>();


    }

    static void foo(List<? extends Cat> pets){

    }
}
