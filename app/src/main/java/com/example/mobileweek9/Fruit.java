package com.example.mobileweek9;

import java.util.ArrayList;

public class Fruit {
    private String name;
    private int calories;
    private double carbs;
    private double fiber;
    private String keyBenefit;
    private int imageResId;
    private static ArrayList<Fruit> fruits;

    public Fruit(String name, int imageResId, int calories, double carbs, double fiber, String keyBenefit) {
        this.name = name;
        this.imageResId = imageResId;
        this.calories = calories;
        this.carbs = carbs;
        this.fiber = fiber;
        this.keyBenefit = keyBenefit;
    }


    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public double getCarbs() {
        return carbs;
    }

    public double getFiber() {
        return fiber;
    }

    public String getKeyBenefit() {
        return keyBenefit;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setKeyBenefit(String keyBenefit) {
        this.keyBenefit = keyBenefit;
    }

}