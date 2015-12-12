package nl.endran.kotlinexample

import android.support.design.widget.Snackbar
import android.view.View

fun View.showSnackBarOnClick(message: Int) {
    setOnClickListener { Snackbar.make(it, "Value is $message", Snackbar.LENGTH_LONG).setAction("Action", null).show() }
}
