package nl.endran.spekexample

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek

class KitchenTest : Spek() {

    init {
        given("a kitchen without chefs") {
            on("placing an order"){
                it("should not allow it"){
                    Assertions.assertThat(true).isFalse()
                }
            }
        }
    }
}