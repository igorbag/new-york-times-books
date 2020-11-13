package br.com.ny_books.data

import br.com.ny_books.data.model.Book
import retrofit2.Call
import retrofit2.http.GET

interface NYTServices {

    @GET("lists.json")
    fun get(): Call<List<Book>>
}