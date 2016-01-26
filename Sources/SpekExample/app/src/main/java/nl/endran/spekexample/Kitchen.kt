package nl.endran.spekexample

data class Chef(val isMasterChef: Boolean, val specialities: List<String>)

class Kitchen(val chefs: List<Chef>) {

    fun getAvailableDishes(): List<String> {
        if(chefs.isEmpty()){
            return emptyList()
        }

        return chefs.first().specialities
    }
}


// We should be able to give a couple of chefs, each with their own speciality
// When atleast one chef is a master chef, AND atleast 2 chefs have that speciality, they can cook that dish
// When there is no master chef, atleast 4 chefs need that speciality