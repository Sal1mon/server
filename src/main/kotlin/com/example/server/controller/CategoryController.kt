package com.example.server.controller

import com.example.server.model.Category
import com.example.server.repository.CategoryRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.PostConstruct

@RestController
@RequestMapping("/category")
class CategoryController (
        private val repository: CategoryRepository
) {
    @PostConstruct
    fun init() {
        listOf(
                Category(0, 1, "Зарплата"),
                Category(0, 1, "Вклад"),
                Category(0, 1, "Пассивный доход"),
                Category(0, 1, "Подарок"),
                Category(0, 2, "Еда и Напитки"),
                Category(0, 2, "Одежда"),
                Category(0, 2, "Дом"),
                Category(0, 2, "Дети"),
                Category(0, 2, "Ремонт"),
                Category(0, 2, "Развлечения"),
                Category(0, 2, "Авто"),
        ).forEach { repository.save(it) }
    }

    @PostMapping("/insertAll")
    fun saveAll(categories: List<Category>) : List<Category> {
        return repository.saveAll(categories)
    }
}