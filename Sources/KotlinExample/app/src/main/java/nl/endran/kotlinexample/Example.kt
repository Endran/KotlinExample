package nl.endran.kotlinexample

import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.view.View

class Example(val fab: FloatingActionButton) {

    fun doMagic() {
        val message = "Replace with your own action"
        fab.showSnackBarOnClick(message)
    }
}
