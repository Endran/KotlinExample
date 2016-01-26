package nl.endran.demotime.test

import android.support.design.widget.Snackbar
import android.view.View

fun View.showSnackbarOnClick(message : String) {
    setOnClickListener {
        Snackbar.make(it, message, Snackbar.LENGTH_LONG).setAction("Action", null).show()
    }

}
