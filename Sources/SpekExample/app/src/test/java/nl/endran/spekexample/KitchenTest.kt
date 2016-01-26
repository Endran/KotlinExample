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
        given("a kitchen with 2 chefs that both have $baconSpeciality as a speciality") {
            val kitchen = Kitchen(listOf(
                    Chef(baconSpeciality),
                    Chef(baconSpeciality)))

            on("asking the list of available dishes") {
                val availableDishes = kitchen.getAvailableDishes()

                it("should return $baconSpeciality") {
                    Assertions.assertThat(availableDishes).isEqualTo(baconSpeciality)
                }
            }
        }


        val baconAndFishSpeciality = listOf("Bacon", "Fish")
        given("a kitchen with a chef with $baconAndFishSpeciality and a chef with $baconSpeciality") {
            val kitchen = Kitchen(listOf(
                    Chef(baconAndFishSpeciality),
                    Chef(baconSpeciality)))

            on("asking the list of available dishes") {
                val availableDishes = kitchen.getAvailableDishes()

                it("should return a $baconSpeciality") {
                    Assertions.assertThat(availableDishes).isEqualTo(baconSpeciality)
                }
            }
        }
    }
}
