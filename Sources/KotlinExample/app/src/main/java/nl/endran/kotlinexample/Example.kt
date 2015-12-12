package nl.endran.kotlinexample

import android.support.design.widget.FloatingActionButton

class Example(val fab: FloatingActionButton) {

    fun doMagic() {
        fab.showSnackBarOnClick(42, 37) { x, y -> x + y }
    }
}
