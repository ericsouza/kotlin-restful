package com.github.ericsouza.bookt.model

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
data class Book(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @get: NotBlank
    val title: String = "",

    @get: NotBlank
    val author: String = "",

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    val category: Category? = null

)
