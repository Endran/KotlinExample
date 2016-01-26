package nl.endran.spekexample

data class Chef(val dishes: List<String>)

class KotlinKitchen(chefs: List<Chef>)  {

    companion object {
        val MINIMUM_CHEFS = 2
        val FAST_PREPARATION_CHEFS = 3
        val NORMAL_PREPARATION_TIME = 30
        val FAST_PREPARATION_TIME = 20
    }

    private val dishMap by lazy {
        val dishMap = hashMapOf<String, Int>()
        chefs.forEach {
            it.dishes.forEach {
                val count = dishMap[it] ?: 0
                dishMap[it] = count + 1
            }
        }
        return@lazy dishMap
    }

    val availableDishes by lazy {
        val availableDishes = arrayListOf<String>()
        dishMap.forEach {
            if (it.value >= MINIMUM_CHEFS) {
                availableDishes.add(it.key)
            }
        }

        return@lazy availableDishes
    }

    fun calculatePreparationTime(dish: String): Int {
        when (dishMap[dish]) {
            !in 0..(FAST_PREPARATION_CHEFS - 1) -> return FAST_PREPARATION_TIME
            !in 0..(MINIMUM_CHEFS - 1) -> return NORMAL_PREPARATION_TIME
            else -> throw RuntimeException("$dish cannot be prepared")
        }
    }
}

// We should be able to give a couple of chefs, each with their own speciality
// When atleast 2 chefs know how to make it, its on the list
