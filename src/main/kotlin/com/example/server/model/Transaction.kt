package com.example.server.model

import net.minidev.json.annotate.JsonIgnore
import java.math.BigDecimal
import java.security.Identity
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "transaction", schema = "public")
data class Transaction(
        @Id val transactionId: String,
        @Column(name = "wallet_wallet_key", insertable = false, updatable = false) @NotNull val walletKey: String,
        @Column(name = "category_category_id", insertable = false, updatable = false) @NotNull val categoryId: Int,
        val transactionValue: BigDecimal,
        val dateTransaction: String,
        @JsonIgnore
        @ManyToOne(targetEntity = Category::class, fetch = FetchType.LAZY) var category: Category?,
        @JsonIgnore
        @ManyToOne(targetEntity = Wallet::class, fetch = FetchType.LAZY) var wallet: Wallet?
)