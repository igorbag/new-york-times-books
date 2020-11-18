package br.com.ny_books.data.repository

import br.com.ny_books.data.BooksResult

interface BooksRepository {

    fun getBooks(booksResultCallback: (result: BooksResult) -> Unit)
}