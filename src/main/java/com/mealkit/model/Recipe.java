package com.mealkit.model;

public class Recipe {
    // Required
    private final String title;
    private final String category;
    private final int servings;
    private final int prepTimeMinutes;
    // Optional
    private final int spicinessLevel;
    private final boolean isVegetarian;
    private final boolean requiresBaking;
    private final int bakingTemperature;
    private final String sauceType;
    private final NutritionalValue nutrition;

    private Recipe(Builder builder) {
        this.title = builder.title;
        this.category = builder.category;
        this.servings = builder.servings;
        this.prepTimeMinutes = builder.prepTimeMinutes;
        this.spicinessLevel = builder.spicinessLevel;
        this.isVegetarian = builder.isVegetarian;
        this.requiresBaking = builder.requiresBaking;
        this.bakingTemperature = builder.bakingTemperature;
        this.sauceType = builder.sauceType;
        this.nutrition = builder.nutrition;
    }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public int getServings() { return servings; }
    public int getPrepTimeMinutes() { return prepTimeMinutes; }
    public int getSpicinessLevel() { return spicinessLevel; }
    public boolean isVegetarian() { return isVegetarian; }
    public boolean isRequiresBaking() { return requiresBaking; }
    public int getBakingTemperature() { return bakingTemperature; }
    public String getSauceType() { return sauceType; }
    public NutritionalValue getNutrition() { return nutrition; }

    @Override
    public String toString() {
        return "Recipe: " + title + " [" + category + "], Servings: " + servings +
                ", Time: " + prepTimeMinutes + "m, Nutrition: " + nutrition;
    }

    public static class Builder {
        private final String title;
        private final String category;
        private final int servings;
        private final int prepTimeMinutes;

        private int spicinessLevel = 0;
        private boolean isVegetarian = false;
        private boolean requiresBaking = false;
        private int bakingTemperature = 0;
        private String sauceType = "None";
        private NutritionalValue nutrition = new NutritionalValue(0, 0, 0, 0);

        public Builder(String title, String category, int servings, int prepTimeMinutes) {
            this.title = title;
            this.category = category;
            this.servings = servings;
            this.prepTimeMinutes = prepTimeMinutes;
        }
        public Builder withSpiciness(int level) {    // 0-10, 0-3 normal
            this.spicinessLevel = level;
            return this;
        }
        public Builder makeVegetarian() {
            this.isVegetarian = true;
            return this;
        }
        public Builder bakeAtTemperature(int tempCelsius) {
            this.requiresBaking = true;
            this.bakingTemperature = tempCelsius;
            return this;
        }
        public Builder withSauce(String sauce) {
            this.sauceType = sauce;
            return this;
        }
        public Builder withNutrition(int calories, int protein, int fat, int carbs) {
            this.nutrition = new NutritionalValue(calories, protein, fat, carbs);
            return this;
        }
        public Recipe build() {
            validate();
            return new Recipe(this);
        }
        private void validate() {
            if (title == null || title.isBlank()) throw new IllegalArgumentException("Title cannot be empty");
            if (servings <= 0) throw new IllegalArgumentException("Servings must be positive");
            if (prepTimeMinutes <= 0) throw new IllegalArgumentException("Prep time must be positive");
            if (requiresBaking && (bakingTemperature < 100 || bakingTemperature > 250)) {
                throw new IllegalStateException("Baking temperature must be between 100°C and 250°C");
            }
            if (isVegetarian && spicinessLevel > 3) {
                throw new IllegalStateException("Vegetarian dishes cannot have a spiciness level above 3");
            }
        }
    }
}