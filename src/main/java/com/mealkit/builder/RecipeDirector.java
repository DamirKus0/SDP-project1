package com.mealkit.builder;
import com.mealkit.model.Recipe;
public class RecipeDirector {
    public Recipe makeVeganSalad() {
        return new Recipe.Builder("Fresh Avocado Salad", "Salad", 1, 10)
                .makeVegetarian()
                .withSauce("Olive Oil & Lemon")
                .withNutrition(250, 5, 20, 15)
                .build();
    }
    public Recipe makeCreamyPasta() {
        return new Recipe.Builder("Chicken Alfredo Pasta", "Main Course", 2, 25)
                .withSauce("Creamy Garlic")
                .withSpiciness(1)
                .withNutrition(650, 35, 25, 60)
                .build();
    }
    public Recipe makeBakedPizza() {
        return new Recipe.Builder("Margherita Pizza", "Bakery", 4, 40)
                .bakeAtTemperature(220)
                .makeVegetarian()
                .withSauce("Tomato Basil")
                .withNutrition(900, 30, 35, 110)
                .build();
    }
}