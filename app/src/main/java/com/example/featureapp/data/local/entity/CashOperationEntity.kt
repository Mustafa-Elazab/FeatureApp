package com.example.featureapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CashOperationEntity(
    @PrimaryKey(autoGenerate = true)
    val primaryKey: Int = 0,
    val category: String,
    val amount: String,
    val type: String
)
