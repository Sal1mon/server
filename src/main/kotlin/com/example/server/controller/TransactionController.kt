package com.example.server.controller

import com.example.server.model.Transaction
import com.example.server.repository.CategoryRepository
import com.example.server.repository.TransactionRepository
import com.example.server.repository.WalletRepository
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.persistence.EntityNotFoundException

@RestController
@RequestMapping("/transaction")
class TransactionController (
        private val repository: TransactionRepository,
        private val catRepository: CategoryRepository,
        private val walletRepository: WalletRepository
) {
    @PostMapping
    fun save(@RequestBody transaction: Transaction) : Transaction {
        val category = catRepository.findById(transaction.categoryId);
        transaction.category = category.orElseThrow{EntityNotFoundException()};
        val wallet = walletRepository.findById(transaction.walletKey);
        transaction.wallet =  wallet.orElseThrow{EntityNotFoundException()}
        return repository.save(transaction)
    }

    @DeleteMapping
    fun delete(@RequestParam("trasactID") transactID : String){
        repository.deleteById(transactID);
    }

    @GetMapping
    fun getAllByWalletId(@RequestParam("walletKey") walletKey: String) : List<Transaction> {
        return repository.findAllByWalletKey(walletKey)
    }
}