package com.example.evan.project1;

/*
Evan Jensen - Project 1 (Mobile App Development) - March 2018

The purpose of this project is to design daily food plan. The
program makes a daily menu allowing you to quickly design each
meal (breakfast, lunch, and dinner) using a selection of food.
 */

public class FoodItem {
    private String food;
    private int calories;

    public FoodItem(String food, int calories) {
        this.food = food;
        this.calories = calories;
    }

    public String getFood(){
        return this.food;
    }

    public int getCalories(){
        return this.calories;
    }
}
