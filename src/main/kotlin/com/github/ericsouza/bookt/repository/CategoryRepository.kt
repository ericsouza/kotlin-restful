package com.github.ericsouza.bookt.repository

import com.github.ericsouza.bookt.model.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository: JpaRepository<Category, Long> {
}