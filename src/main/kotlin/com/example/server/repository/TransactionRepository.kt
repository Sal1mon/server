package com.example.server.repository

import com.example.server.model.Transaction
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface TransactionRepository: JpaRepository<Transaction, String> {
  //  @Query("SELECT * FROM transaction WHERE walletId = ?")
    fun findAllByWalletKey(walletKey: String): List<Transaction>
}