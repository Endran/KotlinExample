package nl.endran.kotlinexample

import android.support.design.widget.FloatingActionButton

class Example(val fab: FloatingActionButton) {

    fun doMagic() {
        val listOf = listOf(1, 2, 3, 4, 5)
        val reduced = listOf.reduce(function())
        fab.showSnackBarOnClick(0, reduced, function())
    }

    private fun function() = { x : Int, y : Int -> x + y }
}
