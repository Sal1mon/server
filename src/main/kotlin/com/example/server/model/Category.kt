package com.example.server.model

import org.hibernate.validator.constraints.Range
import javax.persistence.*

@Entity
@Table(name = "category", schema = "public")
data class Category (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val categoryId: Int,
        @Range(min = 1, max = 2) val categoryType: Int,
        val categoryName: String
)