package com.example.evan.project1;

/*
Evan Jensen - Project 1 (Mobile App Development) - March 2018

The purpose of this project is to design daily food plan. The
program makes a daily menu allowing you to quickly design each
meal (breakfast, lunch, and dinner) using a selection of food.
 */

import java.util.ArrayList;
import java.util.Random;

public class MakeLunch{
    int mealMax, mealMin, mealTotal;
    ArrayList<FoodItem> lunchMenu = new ArrayList<>();

    public MakeLunch(int maxCals, int minCals){

        mealMax = (int)(maxCals*0.33)-200;
        mealMin = (int)(minCals*0.33);
        mealTotal = 0;

        // Define menus
        ArrayList<FoodItem> grains = new ArrayList<>();
        grains.add(new FoodItem("Bread (1 slice)", 70));
        grains.add(new FoodItem("Toast (2 slices)", 200));
        grains.add(new FoodItem("Bagel", 290));
        grains.add(new FoodItem("Dinner Roll", 150));

        ArrayList<FoodItem> fruits = new ArrayList<>();
        fruits.add(new FoodItem("Banana", 89));
        fruits.add(new FoodItem("Banana (1/2)", 44));
        fruits.add(new FoodItem("Banana (1/4)", 22));
        fruits.add(new FoodItem("Blueberries (1 cup)", 84));
        fruits.add(new FoodItem("Apple", 80));
        fruits.add(new FoodItem("Fruit salad (2 cups)", 200));
        fruits.add(new FoodItem("Salsa (4oz)",30));

        ArrayList<FoodItem> vegs = new ArrayList<>();
        vegs.add(new FoodItem("Potatoes (1/2 cup)",200));
        vegs.add(new FoodItem("Mixed vegetables", 100));
        vegs.add(new FoodItem("Veggie spread",20));
        vegs.add(new FoodItem("Avocado",160));
        vegs.add(new FoodItem("Avocado (1/2)",90));
        vegs.add(new FoodItem("Broccoli",34));
        vegs.add(new FoodItem("Asparagus",10));
        vegs.add(new FoodItem("Carrots (1 cup)",20));

        ArrayList<FoodItem> dairy = new ArrayList<>();
        dairy.add(new FoodItem("Greek yogurt (8oz)",120));
        dairy.add(new FoodItem("Cream cheese", 100));
        dairy.add(new FoodItem("Skim milk (1 cup)", 90));
        dairy.add(new FoodItem("2% Milk (1 cup)",125));
        dairy.add(new FoodItem("Ice cream (4oz)", 145));

        ArrayList<FoodItem> protein = new ArrayList<>();
        protein.add(new FoodItem("Two eggs", 140));
        protein.add(new FoodItem("Hot dog", 135));
        protein.add(new FoodItem("Pork chop (3oz)", 220));
        protein.add(new FoodItem("Tuna (3oz)", 100));
        protein.add(new FoodItem("Chicken breast (3oz)", 140));

        ArrayList<FoodItem> fats = new ArrayList<>();
        fats.add(new FoodItem("Choc Chips (10)",10));
        fats.add(new FoodItem("Honey",10));
        fats.add(new FoodItem("Yellow cake", 250));
        fats.add(new FoodItem("Soda (12oz)", 140));


        // Grab food items from each category

        FoodItem item;
        while(mealTotal<mealMin){
            if(mealTotal<mealMax) {
                item = getRandomItem(grains);
                mealTotal = mealTotal + item.getCalories();
                lunchMenu.add(item);
            }
            if(mealTotal<mealMin) {
                item = getRandomItem(dairy);
                mealTotal = mealTotal + item.getCalories();
                lunchMenu.add(item);
            }
            if(mealTotal<mealMax) {
                item = getRandomItem(protein);
                mealTotal = mealTotal + item.getCalories();
                lunchMenu.add(item);
            }
            if(mealTotal<mealMin) {
                item = getRandomItem(fruits);
                mealTotal = mealTotal + item.getCalories();
                lunchMenu.add(item);
            }
            if(mealTotal<mealMin){
                item = getRandomItem(vegs);
                mealTotal = mealTotal + item.getCalories();
                lunchMenu.add(item);
            }
            if(mealTotal<mealMin){
                item = getRandomItem(fats);
                mealTotal = mealTotal + item.getCalories();
                lunchMenu.add(item);
            }
        }


    }
    public FoodItem getRandomItem(ArrayList<FoodItem> category){
        Random random = new Random();
        int index = random.nextInt(category.size());
        return category.get(index);
    }
    public ArrayList<FoodItem> getNewLunch(){
        return this.lunchMenu;
    }
}
