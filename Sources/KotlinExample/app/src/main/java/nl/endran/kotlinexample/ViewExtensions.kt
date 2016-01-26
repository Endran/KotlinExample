package nl.endran.kotlinexample

import android.support.design.widget.Snackbar
import android.view.View

fun View.showSnackbar(a: Int, b: Int, operation: (x: Int, y: Int) -> String) {
    Snackbar.make(this, operation(a, b), Snackbar.LENGTH_LONG).setAction("Action", null).show()
}
