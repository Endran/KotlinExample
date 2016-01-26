package nl.endran.spekexample

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek

class KitchenTest : Spek() {


    init {
        given("a kitchen without chefs") {

            val kitchen = Kitchen(emptyList())

            on("asking the list of available dishes") {
                val availableDishes = kitchen.getAvailableDishes()

                it("should return an empty list") {
                    Assertions.assertThat(availableDishes).isEmpty()
                }
            }
        }

        val baconSpeciality = listOf("Bacon")
        given("a kitchen with 3 master chefs that all have $baconSpeciality as a speciality") {
            val kitchen = Kitchen(listOf(
                    Chef(true, baconSpeciality),
                    Chef(true, baconSpeciality),
                    Chef(true, baconSpeciality)))

            on("asking the list of available dishes") {
                val availableDishes = kitchen.getAvailableDishes()

                it("should return a $baconSpeciality") {
                    Assertions.assertThat(availableDishes).isEqualTo(baconSpeciality)
                }
            }
        }
    }
}
