package br.com.ny_books.presentation.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import br.com.ny_books.R
import br.com.ny_books.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_book_details.*
import kotlinx.android.synthetic.main.include_toolbar.*

class BookDetailsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)

        setUpToolbar(toolbarMain, R.string.book_details_title, true)

        bookDetailTitle.text = intent.getStringExtra(EXTRA_TITLE)
        bookDescription.text = intent.getStringExtra(EXTRA_DESCRIPTION)
    }

    companion object {
        private const val EXTRA_TITLE = "EXTRA_TITLE"
        private const val EXTRA_DESCRIPTION = "EXTRA_DESCRIPTION"
        fun getStartIntent(context: Context, title: String, descption: String): Intent {
            return Intent(context, BookDetailsActivity::class.java).apply {
                putExtra(EXTRA_TITLE, title)
                putExtra(EXTRA_DESCRIPTION, descption)
            }
        }
    }
}