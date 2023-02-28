package com.example.featureapp.data.local.entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "visa")
data class VisaEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "bankName")
    val bankName: String,
    @ColumnInfo(name = "cardHolder")
    val cardHolder: String,
    @ColumnInfo(name = "cardNumber")
    val cardNumber: String,
    @ColumnInfo(name = "expiryDate")
    val expiryDate: String,
    @ColumnInfo(name = "cvv")
    val cvv: String?,
)