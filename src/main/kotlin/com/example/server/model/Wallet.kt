package com.example.server.model

import java.math.BigDecimal
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "wallet", schema = "public")
data class Wallet (
        @Id val walletKey: String,
        val cashValue: BigDecimal
)