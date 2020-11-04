package com.github.ericsouza.bookt.controller

import com.github.ericsouza.bookt.model.Category
import com.github.ericsouza.bookt.repository.CategoryRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/category")
class CategoryController (private val categoryRepository: CategoryRepository){

    @GetMapping("/")
    fun getAllCategories(): List<Category> = categoryRepository.findAll()

    @PostMapping("/")
    fun createCategory(@Valid @RequestBody category: Category): ResponseEntity<Category> {
        categoryRepository.save(category)
        return ResponseEntity.ok(category)
    }

    @GetMapping("/{id}")
    fun getCategoryById(@PathVariable("id") categoryId: Long): ResponseEntity<Category> {
        val c: Optional<Category> = categoryRepository.findById(categoryId)

        if (c.isPresent) return ResponseEntity.ok(c.get())
        return ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteCategoryById(@PathVariable("id") categoryId: Long): ResponseEntity<Category> {
        val c: Optional<Category> = categoryRepository.findById(categoryId)

        if (c.isPresent) {
            categoryRepository.delete(c.get())
            return ResponseEntity.notFound().build()
        }

        return ResponseEntity.notFound().build()
    }



}