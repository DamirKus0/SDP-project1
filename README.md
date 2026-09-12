# Meal Kit Recipe Generator
A Java application for building valid, customizable culinary
recipes for a personalized meal kit service using the Builder Pattern.

# What It Does

Custom Meals: Builds recipes with custom portions, spiciness, baking options, and nutritional values.
Safety Rules: Prevents invalid recipes (e.g., enforces baking temperatures between 100°C–250°C and caps vegetarian spiciness at level 3).
Immutable Objects: Ensures once a recipe is built, it cannot be modified.

# Usage Example

  java
Recipe pizza = new Recipe.Builder("Margherita Pizza", "Bakery", 4, 40)
.bakeAtTemperature(220)
.makeVegetarian()
.withSauce("Tomato Basil")
.withNutrition(900, 30, 35, 110)
.build();

  