package nl.endran.spekexample;

import java.util.List;

public interface Kitchen {
    public List<String> getAvailableDishes();
    public int calculatePreparationTime(String dish);
}
