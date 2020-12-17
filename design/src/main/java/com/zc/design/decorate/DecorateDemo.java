package com.zc.design.decorate;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class DecorateDemo {

    public static void main(String[] args) throws FileNotFoundException {

        Food food = new SugarDecorate(new Bread());
        food.describe();


    }

}
