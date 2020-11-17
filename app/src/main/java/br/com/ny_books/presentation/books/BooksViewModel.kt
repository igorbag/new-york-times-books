package br.com.ny_books.presentation.books

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.ny_books.data.ApiService
import br.com.ny_books.data.model.Book
import br.com.ny_books.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel : ViewModel() {

    val booksLiveData: MutableLiveData<List<Book>> = MutableLiveData()

    fun getBooks() {
        ApiService.service.getBooks().enqueue(object : Callback<BookBodyResponse> {
            override fun onResponse(
                call: Call<BookBodyResponse>,
                response: Response<BookBodyResponse>
            ) {
                if (response.isSuccessful) {
                    val books: MutableList<Book> = mutableListOf()
                    response.body()?.let { bookBodyResponse ->
                        for (results in bookBodyResponse.bookResults) {
                            val book = Book(
                                title = results.bookDetailResponses[0].title,
                                author = results.bookDetailResponses[0].author,
                                description = results.bookDetailResponses[0].description
                            )
                            books.add(book)
                        }
                    }
                    booksLiveData.value = books
                }
            }

            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}