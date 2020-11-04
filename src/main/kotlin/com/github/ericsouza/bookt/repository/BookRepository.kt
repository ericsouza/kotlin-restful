package com.github.ericsouza.bookt.repository

import com.github.ericsouza.bookt.model.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository: JpaRepository<Book, Long> {
}