package com.mealkit.model;
public class NutritionalValue {
    private final int calories;
    private final int proteinGrams;
    private final int fatGrams;
    private final int carbGrams;

    public NutritionalValue(int calories, int proteinGrams, int fatGrams, int carbGrams) {
        this.calories = calories;
        this.proteinGrams = proteinGrams;
        this.fatGrams = fatGrams;
        this.carbGrams = carbGrams;
    }

    public int getCalories() { return calories; }
    public int getProteinGrams() { return proteinGrams; }
    public int getFatGrams() { return fatGrams; }
    public int getCarbGrams() { return carbGrams; }

    @Override
    public String toString() {
        return calories + " kcal (Protein:" + proteinGrams + "g, Fat:" + fatGrams + "g, Carb:" + carbGrams + "g)";
    }
}