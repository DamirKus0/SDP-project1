package com.mealkit;
import com.mealkit.builder.RecipeDirector;
import com.mealkit.model.Recipe;
public class Main {
    public static void main(String[] args) {
        Recipe myBurger = new Recipe.Builder("Burger", "Fast Food", 1, 15)
                .withSauce("BBQ")
                .withSpiciness(1)
                .withNutrition(600, 25, 30, 50)
                .build();
        System.out.println(myBurger);
        Recipe Sushi = new Recipe.Builder("Sushi", "Fast Food", 8, 20)
                .withSauce("Soeviy sous")
                .withSpiciness(0)
                .withNutrition(500,25,20,40)
                .build();
        System.out.println(Sushi);
    }
}