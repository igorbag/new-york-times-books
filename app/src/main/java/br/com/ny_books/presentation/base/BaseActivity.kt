package br.com.ny_books.presentation.base


import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

open class BaseActivity : AppCompatActivity() {

    protected fun setUpToolbar(toolbar: Toolbar, title: Int, showBackButton: Boolean = false) {
        toolbar.title = getString(title)
        setSupportActionBar(toolbar)

        if (showBackButton) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }

}