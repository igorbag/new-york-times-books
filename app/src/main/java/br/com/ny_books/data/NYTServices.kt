package br.com.ny_books.data

import br.com.ny_books.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NYTServices {

    @GET("lists.json")
    fun getBooks(
        @Query("api-key") apiKey: String = "y73l4B2NXwUtJGOFpdO8ALG4T9qr7zNs",
        @Query("list") list: String = "hardcover-fiction"
    ): Call<BookBodyResponse>
}