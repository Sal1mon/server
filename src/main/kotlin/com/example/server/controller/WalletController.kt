package com.example.server.controller

import com.example.server.model.Wallet
import com.example.server.repository.WalletRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/wallet")
class WalletController (
        private val repository: WalletRepository
){
        @GetMapping("/{id}")
        fun getOne(@PathVariable("id") id: String) : ResponseEntity<Wallet> {
                return repository.findById(id)
                        .map { ResponseEntity.ok(it) }
                        .orElse(ResponseEntity.notFound().build())
        }
        @PostMapping
        fun save(@RequestBody wallet: Wallet) : Wallet {
                return repository.save(wallet)
        }
}