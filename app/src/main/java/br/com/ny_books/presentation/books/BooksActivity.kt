package br.com.ny_books.presentation.books

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.ny_books.R
import kotlinx.android.synthetic.main.activity_books_main.*


class BooksActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books_main)
        toolbarMain.title = "Books"
        setSupportActionBar(toolbarMain)

    }
}