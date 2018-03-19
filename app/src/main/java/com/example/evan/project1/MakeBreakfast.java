package com.example.evan.project1;

/*
Evan Jensen - Project 1 (Mobile App Development) - March 2018

The purpose of this project is to design daily food plan. The
program makes a daily menu allowing you to quickly design each
meal (breakfast, lunch, and dinner) using a selection of food.
 */

import java.util.ArrayList;
import java.util.Random;

public class MakeBreakfast{
    int mealMax, mealMin, mealTotal;
    ArrayList<FoodItem> breakfastMenu = new ArrayList<>();

    public MakeBreakfast(int maxCals, int minCals){

        mealMax = (int)(maxCals*0.33)-200;
        mealMin = (int)(minCals*0.33);
        mealTotal = 0;

        // Define Menus
        ArrayList<FoodItem> grains = new ArrayList<>();
        grains.add(new FoodItem("Toast (1 slice)", 100));
        grains.add(new FoodItem("Toast (2 slices)", 200));
        grains.add(new FoodItem("Bagel", 290));
        grains.add(new FoodItem("Cereal", 140));
        grains.add(new FoodItem("Oatmeal (1 cup)", 145));
        grains.add(new FoodItem("Oatmeal (1/2 cup)", 72));
        grains.add(new FoodItem("Oatmeal (1/4 cup)", 36));

        ArrayList<FoodItem> fruits = new ArrayList<>();
        fruits.add(new FoodItem("Banana", 89));
        fruits.add(new FoodItem("Banana (1/2)", 44));
        fruits.add(new FoodItem("Banana (1/4)", 22));
        fruits.add(new FoodItem("Blueberries (1 cup)", 84));
        fruits.add(new FoodItem("Apple", 80));
        fruits.add(new FoodItem("Fruit salad (2 cups)", 200));

        ArrayList<FoodItem> vegs = new ArrayList<>();
        vegs.add(new FoodItem("Potatoes (1/2 cup)",200));
        vegs.add(new FoodItem("Hash browns (1/4 cup)",100));
        vegs.add(new FoodItem("Mixed vegetables", 100));

        ArrayList<FoodItem> dairy = new ArrayList<>();
        dairy.add(new FoodItem("Greek yogurt (8oz)",120));
        dairy.add(new FoodItem("Cream cheese", 100));
        dairy.add(new FoodItem("Skim milk (1 cup)", 90));

        ArrayList<FoodItem> protein = new ArrayList<>();
        protein.add(new FoodItem("Two eggs", 140));
        protein.add(new FoodItem("Sausage patty", 120));
        protein.add(new FoodItem("Scrambled egg", 75));
        protein.add(new FoodItem("Bacon (3 strips)", 140));

        ArrayList<FoodItem> fats = new ArrayList<>();
        fats.add(new FoodItem("Maple syrup (1/4 cup)", 200));
        fats.add(new FoodItem("Whipped cream", 60));
        fats.add(new FoodItem("Choc Chips (10)",10));
        fats.add(new FoodItem("Honey",10));


        // Grab food items from each category
        FoodItem item;
        while(mealTotal<mealMin){
            if(mealTotal<mealMax) {
                item = getRandomItem(grains);
                mealTotal = mealTotal + item.getCalories();
                breakfastMenu.add(item);
            }
            if(mealTotal<mealMin) {
                item = getRandomItem(dairy);
                mealTotal = mealTotal + item.getCalories();
                breakfastMenu.add(item);
            }
            if(mealTotal<mealMax) {
                item = getRandomItem(protein);
                mealTotal = mealTotal + item.getCalories();
                breakfastMenu.add(item);
            }
            if(mealTotal<mealMin) {
                item = getRandomItem(fruits);
                mealTotal = mealTotal + item.getCalories();
                breakfastMenu.add(item);
            }
            if(mealTotal<mealMin){
                item = getRandomItem(vegs);
                mealTotal = mealTotal + item.getCalories();
                breakfastMenu.add(item);
            }
            if(mealTotal<mealMin){
                item = getRandomItem(fats);
                mealTotal = mealTotal + item.getCalories();
                breakfastMenu.add(item);
            }
        }


    }

    // Method to get random food item from provided list
    public FoodItem getRandomItem(ArrayList<FoodItem> category){
        Random random = new Random();
        int index = random.nextInt(category.size());
        return category.get(index);
    }

    // Method that returns a meal between recommended calories
    public ArrayList<FoodItem> getNewBreakfast(){
        return this.breakfastMenu;
    }
}
