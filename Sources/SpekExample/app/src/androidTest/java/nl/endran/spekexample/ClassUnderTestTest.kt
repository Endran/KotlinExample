package nl.endran.spekexample

import org.jetbrains.spek.api.Spek

class ClassUnderTestTest : Spek() {

    @Mock
    lateinit var favoritesPreferenceAction: Action1<in Set<String>>

    init {
        MockitoAnnotations.initMocks(this)

        given ("a kitchen without chefs") {

            on("placing an order") {

                it("should not allow it") {
                    Assertions.assertThat(true).isFalse()
                }
            }
        }
    }
}
