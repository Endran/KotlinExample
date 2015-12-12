package nl.endran.kotlinexample

import android.support.design.widget.Snackbar
import android.view.View

fun View.showSnackBarOnClick(a: Int, b: Int, operation: (x: Int, y: Int) -> Int) {
    setOnClickListener { Snackbar.make(it, "Value is ${operation(a, b)}", Snackbar.LENGTH_LONG).setAction("Action", null).show() }
}
