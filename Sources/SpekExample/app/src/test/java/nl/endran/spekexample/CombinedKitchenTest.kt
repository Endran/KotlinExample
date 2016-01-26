package nl.endran.spekexample

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek

class CombinedKitchenTest : Spek() {

    val bacon = "Bacon"
    val chicken = "Chicken"
    val fish = "Fish"

    init {
        executeTests ("KotlinKitchen") {
            KotlinKitchen(it)
        }

        executeTests("JavaKitchen") {
            JavaKitchen(it)
        }
    }

    private fun executeTests(kitchenName: String, kitchenFactory: ((List<Chef>) -> Kitchen)) {
        given("a $kitchenName without chefs") {
            val kitchen = kitchenFactory(emptyList())

            on("asking the list of available dishes") {
                val availableDishes = kitchen.availableDishes

                it("should return an empty list") {
                    Assertions.assertThat(availableDishes).isEmpty()
                }
            }
        }

        val baconSpeciality = listOf(bacon)
        given("a $kitchenName with 2 chefs that both have $baconSpeciality as a speciality") {
            val kitchen = kitchenFactory(listOf(
                    Chef(baconSpeciality),
                    Chef(baconSpeciality)))

            on("asking the list of available dishes") {
                val availableDishes = kitchen.availableDishes

                it("should contain $bacon") {
                    Assertions.assertThat(availableDishes).contains(bacon)
                }
            }

            on("requesting the preparation time for $bacon") {
                val preparationTime = kitchen.calculatePreparationTime(bacon)

                it("should take ${KotlinKitchen.NORMAL_PREPARATION_TIME} minutes") {
                    Assertions.assertThat(preparationTime).isEqualTo(KotlinKitchen.NORMAL_PREPARATION_TIME)
                }
            }
        }

        val baconAndChickenSpeciality = listOf(bacon, chicken)
        val baconFishAndChickenSpeciality = listOf(bacon, fish, chicken)
        given("a $kitchenName with a chef with $baconAndChickenSpeciality, a chef with $baconSpeciality and a chef with $baconFishAndChickenSpeciality") {
            val kitchen = kitchenFactory(listOf(
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
                val preparationTime = kitchen.calculatePreparationTime(bacon)

                it("should take ${KotlinKitchen.FAST_PREPARATION_TIME} minutes") {
                    Assertions.assertThat(preparationTime).isEqualTo(KotlinKitchen.FAST_PREPARATION_TIME)
                }
            }

            on("requesting the preparation time for $chicken") {
                val preparationTime = kitchen.calculatePreparationTime(chicken)

                it("should take ${KotlinKitchen.NORMAL_PREPARATION_TIME} minutes") {
                    Assertions.assertThat(preparationTime).isEqualTo(KotlinKitchen.NORMAL_PREPARATION_TIME)
                }
            }

            on("requesting the preparation time for $fish") {
                var exception: RuntimeException? = null
                try {
                    kitchen.calculatePreparationTime(fish)
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
