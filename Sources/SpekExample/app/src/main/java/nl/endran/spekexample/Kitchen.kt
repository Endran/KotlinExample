package nl.endran.spekexample

data class Chef(val specialities: List<String>)

class Kitchen(val chefs: List<Chef>) {

    fun getAvailableDishes(): List<String> {
        if (chefs.isEmpty()) {
            return emptyList()
        }

        val hashMap = hashMapOf<String, Int>()
        chefs.forEach {
            it.specialities.forEach {
                val count = hashMap[it] ?: 0
                hashMap[it] = count + 1
            }
        }

        val availableDishes = arrayListOf<String>()
        hashMap.forEach {
            if(it.value>=2){
                availableDishes.add(it.key)
            }
        }

        return availableDishes
    }
}


// We should be able to give a couple of chefs, each with their own speciality
// When atleast 2 chefs know how to make it, its on the list