package com.github.ericsouza.bookt.controller;

import com.github.ericsouza.bookt.model.Book;
import com.github.ericsouza.bookt.repository.BookRepository;
import com.github.ericsouza.bookt.repository.CategoryRepository;
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid


@RestController
@RequestMapping("/book")
public class BookController(private val bookRepository: BookRepository, private val categoryRepository: CategoryRepository) {
    @GetMapping("")
    fun getAllBooks(): List<Book> = bookRepository.findAll()

    @PostMapping()
    fun createBook(@Valid @RequestBody book: Book): ResponseEntity<Book> {
        book.category?.let { categoryRepository.save(it) }
        bookRepository.save(book)
        return ResponseEntity.ok(book)

    }

    @GetMapping("/{id}")
    fun getBookById(@PathVariable(value = "id") bookId: Long): ResponseEntity<Book> {
        val b: Optional<Book> = bookRepository.findById(bookId)

        if (b.isPresent) return ResponseEntity.ok(b.get())

        return ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteBookById(@PathVariable("id") bookId: Long): ResponseEntity<Void> {
        val b: Optional<Book> = bookRepository.findById(bookId)

        if (b.isPresent) {
            bookRepository.delete(b.get())
            return ResponseEntity.ok().build()
        }
        return ResponseEntity.notFound().build()
    }
}
