package nl.endran.kotlinexample

import android.support.design.widget.Snackbar
import android.view.View

fun View.showSnackBarOnClick(message: String) {
    setOnClickListener { Snackbar.make(it, message, Snackbar.LENGTH_LONG).setAction("Action", null).show() }
}
