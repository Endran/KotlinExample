package nl.endran.kotlinexample

import android.support.design.widget.FloatingActionButton
import android.view.View

data class MyDataClass(var anInt: Int, val perhapsAlsoAString: String, val andWhatAboutComplexClasses: MyFirstKotlin)

class MyFirstKotlin(val fab: FloatingActionButton) {

    fun doMagic() {

        val magicValue = listOf(1, 2, 3, 4)
                .map { it * 10 }
                .filter { it > 20 }
                .reduce { x, y -> x + y }

        fab.setOnClickListener {
            fab.showSnackbar(0, magicValue, firstClassCitizen())
        }
    }

    fun doMagic(any: Any?) {
        if (any is View) {

            var magicValue = 0;
            listOf(1, 2, 3, 4)
                    .forEach { magicValue += it }

            any.setOnClickListener {
                any.showSnackbar(0, magicValue) {
                    x, y ->
                    "This is also cool, $x times $y is ${x * y}"
                }
            }
        }
    }

    private fun firstClassCitizen() = { x: Int, y: Int -> "The sum of $x and $y is ${x + y}" }
}
