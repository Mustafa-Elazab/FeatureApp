package com.example.featureapp.domain.repository


import com.example.featureapp.data.local.entity.CashOperationEntity
import kotlinx.coroutines.flow.Flow

interface CashRepository {


    suspend fun getAllCashOperation(): Flow<List<CashOperationEntity>>


    suspend fun insertCashOperation(operation: CashOperationEntity)


    suspend fun deleteOperation(operation: CashOperationEntity)
}