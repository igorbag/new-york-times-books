package br.com.ny_books.presentation.base


import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import br.com.ny_books.R

open class BaseActivity : AppCompatActivity() {

    protected fun setUpToolbar(toolbar: Toolbar, title: Int) {
        toolbar.title = getString(R.string.books_title)
        setSupportActionBar(toolbar)
    }

}