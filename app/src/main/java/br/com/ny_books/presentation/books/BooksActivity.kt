package br.com.ny_books.presentation.books

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.ny_books.R
import br.com.ny_books.presentation.base.BaseActivity
import br.com.ny_books.presentation.details.BookDetailsActivity
import kotlinx.android.synthetic.main.activity_books_main.*
import kotlinx.android.synthetic.main.include_toolbar.*


class BooksActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books_main)

        setUpToolbar(toolbarMain, R.string.books_title)

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(BooksViewModel::class.java)

        viewModel.booksLiveData.observe(this) {
            it?.let { books ->
                with(recyclerBooks) {
                    layoutManager =
                        LinearLayoutManager(this@BooksActivity, RecyclerView.VERTICAL, false)
                    setHasFixedSize(true)
                    adapter = BooksAdapter(books) { book ->
                        val intent = BookDetailsActivity.getStartIntent(
                            this@BooksActivity,
                            book.title,
                            book.description
                        )
                        startActivity(intent)
                    }
                }
            }
        }

        viewModel.viewFlipperLiveData.observe(this, Observer {
            it?.let { viewFlipper ->
                viewFlipperBooks.displayedChild = viewFlipper.first
                viewFlipper.second?.let { errorMessageResId ->
                    textViewError.text = getString(errorMessageResId)
                }
            }
        })
        viewModel.getBooks()
    }
}