package us.mattgreen;

public class Cookbook {

    // Hold all the meals that are read in from the file
    private Meal[] meals = new Meal[100];
    // Hold the next (empty) index in the array
    private int i = 0;

    public void addElementWithStrings(String mealTypeStr, String mealNameStr, String caloriesStr) {
        MealType mealType;

        // Do we have room in the array for one more?
        if (i < meals.length) {

            // Find the correct enum using a switch? Or use .fromValue() instead?
            switch (mealTypeStr) {
                case "Breakfast":
                    mealType = MealType.BREAKFAST;
                    break;
                case "Lunch":
                    mealType = MealType.LUNCH;
                    break;
                case "Dinner":
                    mealType = MealType.DINNER;
                    break;
                case "Dessert":
                    mealType = MealType.DESSERT;
                    break;
                default:
                    mealType = MealType.DINNER;
                    System.out.println("Meal Creation Error: Invalid Meal Type " + mealTypeStr + ", defaulted to Dinner.");
            }

            int calories;

            if (caloriesStr.matches("-?\\d+(\\.\\d+)?")) {
                calories = Integer.parseInt(caloriesStr);
            } else {
                calories = 100;
                System.out.println("Meal Creation Error: Invalid Calories " + caloriesStr + ", defaulted to 100.");
            }
            meals[i++] = new Meal(mealType, mealNameStr, calories);
        } else {
            System.out.println("Meal Creation Error: Items exceeded system size.  File has " + i + ", while the system can only handle " + meals.length + ".");
        }
    }

    public Meal[] getMeals() {
        return meals;
    }

    public void printAllMeals() {
        for (Meal item : meals) {
            if (item != null) {
                System.out.println(item);
            }
        }
    }

    public void printMealsByType(MealType mealType) {
        for (Meal item : meals) {
            if (item != null && item.getMealType() == mealType) {
                System.out.println(item);
            }
        }
    }

    public void printByNameSearch(String s) {
        // Maybe add a message if no match found?
        for (Meal item : meals) {
            // Maybe make this case-insensitive?
            if (item != null && item.getItem().indexOf(s) >= 0) {
                System.out.println(item);
            }
        }
    }
}
