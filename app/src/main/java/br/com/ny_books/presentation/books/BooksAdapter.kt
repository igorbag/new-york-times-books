package br.com.ny_books.presentation.books

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.ny_books.R
import br.com.ny_books.data.model.Book
import kotlinx.android.synthetic.main.item_book.view.*

class BooksAdapter(
    val books: List<Book>,
    private val onItemClickListener: (book: Book) -> Unit
) : RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BooksViewHolder(itemView, onItemClickListener)
    }

    override fun onBindViewHolder(viewHolder: BooksViewHolder, position: Int) {
        viewHolder.bindView(books[position])
    }

    override fun getItemCount() = books.count()

    class BooksViewHolder(
        view: View,
        private val onItemClickListener: (book: Book) -> Unit) :
        RecyclerView.ViewHolder(view) {

        private val title = itemView.textTitle
        private val author = itemView.textAuthor
        fun bindView(book: Book) {
            title.text = book.title
            author.text = book.author

            itemView.setOnClickListener {
                onItemClickListener.invoke(book)
            }
        }
    }
}