package nl.endran.spekexample

// We should be able to give a couple of chefs, each with their own speciality
// When atleast 2 chefs know how to make it, its on the list

interface Kitchen {
    val availableDishes: List<String>
    fun calculatePreparationTime(dish: String): Int
}
