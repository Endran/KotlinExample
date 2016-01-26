package nl.endran.spekexample

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek

class KitchenTest : Spek() {

    val bacon = "Bacon"
    val chicken = "Chicken"
    val fish = "Fish"

    init {
        given("a kitchen without chefs") {
            val kitchen = Kitchen(emptyList())

            on("asking the list of available dishes") {
                val availableDishes = kitchen.availableDishes

                it("should return an empty list") {
                    Assertions.assertThat(availableDishes).isEmpty()
                }
            }
        }

        val baconSpeciality = listOf(bacon)
        given("a kitchen with 2 chefs that both have $baconSpeciality as a speciality") {
            val kitchen = Kitchen(listOf(
                    Chef(baconSpeciality),
                    Chef(baconSpeciality)))

            on("asking the list of available dishes") {
                val availableDishes = kitchen.availableDishes

                it("should contain $bacon") {
                    Assertions.assertThat(availableDishes).contains(bacon)
                }
            }

            on("requesting the preparation time for $bacon") {
                val preparationTime = kitchen.preparationTime(bacon)

                it("should take ${Kitchen.NORMAL_PREPARATION_TIME} minutes") {
                    Assertions.assertThat(preparationTime).isEqualTo(Kitchen.NORMAL_PREPARATION_TIME)
                }
            }
        }

        val baconAndChickenSpeciality = listOf(bacon, chicken)
        val baconFishAndChickenSpeciality = listOf(bacon, fish, chicken)
        given("a kitchen with a chef with $baconAndChickenSpeciality, a chef with $baconSpeciality and a chef with $baconFishAndChickenSpeciality") {
            val kitchen = Kitchen(listOf(
                    Chef(baconAndChickenSpeciality),
                    Chef(baconSpeciality),
                    Chef(baconFishAndChickenSpeciality)))

            on("asking the list of available dishes") {
                val availableDishes = kitchen.availableDishes

                it("should return not return empty list") {
                    Assertions.assertThat(availableDishes).isNotEmpty()
                }

                it("should resemble $baconAndChickenSpeciality") {
                    Assertions.assertThat(availableDishes).containsAll(baconAndChickenSpeciality)
                }
            }

            on("requesting the preparation time for $bacon") {
                val preparationTime = kitchen.preparationTime(bacon)

                it("should take ${Kitchen.FAST_PREPARATION_TIME} minutes") {
                    Assertions.assertThat(preparationTime).isEqualTo(Kitchen.FAST_PREPARATION_TIME)
                }
            }

            on("requesting the preparation time for $chicken") {
                val preparationTime = kitchen.preparationTime(chicken)

                it("should take ${Kitchen.NORMAL_PREPARATION_TIME} minutes") {
                    Assertions.assertThat(preparationTime).isEqualTo(Kitchen.NORMAL_PREPARATION_TIME)
                }
            }

            on("requesting the preparation time for $fish") {
                var exception: RuntimeException? = null
                try {
                    kitchen.preparationTime(fish)
                } catch (e: RuntimeException) {
                    exception = e
                }

                it("should have thrown an exception") {
                    Assertions.assertThat(exception).isNotNull()
                }
            }
        }
    }
}
