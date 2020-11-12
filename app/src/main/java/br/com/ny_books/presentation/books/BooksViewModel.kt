package br.com.ny_books.presentation.books

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.ny_books.data.model.Book

class BooksViewModel : ViewModel() {

    val booksLiveData: MutableLiveData<List<Book>> = MutableLiveData()

    fun getBooks() {
        booksLiveData.value = createFakeBooks();
    }


    fun createFakeBooks(): List<Book> {
        return listOf(
                Book("Title 1", "Author 1"),
                Book("Title 2", "Author 2"),
                Book("Title 3", "Author 3"))
    }
}