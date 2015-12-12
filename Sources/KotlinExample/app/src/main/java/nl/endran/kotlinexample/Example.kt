package nl.endran.kotlinexample

import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.view.View

class Example(val fab: FloatingActionButton) {

    fun doMagic() {
        val i = 42
        fab.showSnackBarOnClick(i)
    }
}
