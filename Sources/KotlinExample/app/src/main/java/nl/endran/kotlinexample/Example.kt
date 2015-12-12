package nl.endran.kotlinexample

import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar

class Example(val fab: FloatingActionButton) {

    fun doMagic() {
        fab.setOnClickListener { view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show() }
    }
}