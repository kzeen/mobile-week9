package com.example.mobileweek9;

import java.util.Arrays;
import java.util.List;

public class FruitsFactory {
    private static List<Fruit> fruitsList=null;

    public static List<Fruit> getFruits() {
        if (fruitsList == null) {
            Fruit[] fruits = new Fruit[]{
                    new Fruit("Apple", R.drawable.apple, 52, 13.8, 2.4, "High in fiber, aids digestion"),
                    new Fruit("Banana", R.drawable.banana, 89, 22.8, 2.6, "High in potassium, boosts energy"),
                    new Fruit("Cherry", R.drawable.cherry, 50, 12, 1.6, "Rich in antioxidants, reduces inflammation"),
                    new Fruit("Kiwi", R.drawable.kiwi, 61, 14.7, 3.0, "Very high in Vitamin C, boosts immunity"),
                    new Fruit("Orange", R.drawable.orange, 47, 11.8, 2.4, "High in Vitamin C, good for skin"),
                    new Fruit("Pineapple", R.drawable.pineapple, 50, 13.1, 1.4, "Contains bromelain, aids digestion"),
                    new Fruit("Strawberry", R.drawable.strawberry, 32, 7.7, 2.0, "Low-calorie, rich in Vitamin C"),
                    new Fruit("Carrot", R.drawable.carrot, 41, 9.6, 2.8, "High in Vitamin A, good for eyes")
            };
            fruitsList = Arrays.asList(fruits);
        }
        return fruitsList;
    }
}
