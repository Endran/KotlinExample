package nl.endran.spekexample;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaKitchen implements Kitchen {

    public static int MINIMUM_CHEFS = 2;
    public static int FAST_PREPARATION_CHEFS = 3;
    public static int NORMAL_PREPARATION_TIME = 30;
    public static int FAST_PREPARATION_TIME = 20;

    private Map<String, Integer> dishMap;
    private List<String> availableDishes;

    @NonNull
    private List<Chef> chefs;

    public JavaKitchen(final @NonNull List<Chef> chefs) {
        this.chefs = chefs;
    }

    private Map<String, Integer> getDishMap() {
        if (dishMap == null) {
            dishMap = new HashMap<>();
            for (final Chef chef : chefs) {
                for (final String dish : chef.getDishes()) {
                    int dishCount = 0;
                    Integer integerDishCount = dishMap.get(dish);
                    if (integerDishCount != null) {
                        dishCount = integerDishCount;
                    }
                    dishMap.put(dish, ++dishCount);
                }
            }
        }
        return dishMap;
    }

    public List<String> getAvailableDishes() {
        if (availableDishes == null) {
            availableDishes = new ArrayList<>();
            Map<String, Integer> dishMap = getDishMap();
            for (final String dish : dishMap.keySet()) {
                if (dishMap.get(dish) >= MINIMUM_CHEFS) {
                    availableDishes.add(dish);
                }
            }
        }

        return availableDishes;
    }

    @Override
    public int calculatePreparationTime(final String dish) {
        Integer integer = getDishMap().get(dish);

        if (integer == null || integer < MINIMUM_CHEFS) {
            throw new RuntimeException(dish + " cannot be prepared");
        }

        if (integer >= FAST_PREPARATION_CHEFS) {
            return FAST_PREPARATION_TIME;
        }

        return NORMAL_PREPARATION_TIME;
    }
}
