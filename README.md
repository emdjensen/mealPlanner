# mealPlanner
Basic meal planning app that presents three meals using random
items, with total calories for the day's meals within the daily
recommended value depending on age, gender, and activity level

Project purpose from professor:
The purpose of this project is to design daily food plan. The
program makes a daily menu allowing you to quickly design each
meal (breakfast, lunch, and dinner) using a selection of food.

Summary of user story and behind the scenes processes:
1. User enters details (Age range, gender, activity level)
2. When button is clicked, method collects data and stores as
   local variables
3. Max and target (min) calories are calculated for user case
4. Min/Max are passed to menu creation methods and classes
5. Meal items are selected randomly for each meal, looped until
   number of calories per meal is less than 1/3 max daily cals
   per day (used to simplify methods to ensure calories are
   within limits per user requirements
6. Meal lists are combined into menu list, which is fed to the
   method that creates the recycler view.
7. RecyclerView creates MenuCards (CardViews) for each meal
8. Recycler view is displayed on MenuActivity to show meals
9. Pressing "refresh" button at top of menu restarts activity,
   which re-generates the menu with arguments (min/max per user)
