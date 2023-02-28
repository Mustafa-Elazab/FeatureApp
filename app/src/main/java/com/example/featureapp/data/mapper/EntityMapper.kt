package com.example.featureapp.data.mapper

import com.example.featureapp.data.local.entity.CashOperationEntity
import com.example.featureapp.data.local.entity.VisaEntity
import com.example.featureapp.domain.model.VisaModel


fun VisaEntity.toModel() = VisaModel(bankName, cardHolder, cardNumber, expiryDate, cvv)
fun VisaModel.toEntity() = VisaEntity(0, bankName, cardHolder, cardNumber, expiryDate, cvv)

//
//fun CashOperationEntity.toModel() = CashOperationModel(category, amount, type)
//fun CashOperationModel.toEntity() = CashOperationEntity(0, category, amount, type)