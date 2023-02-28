package com.example.featureapp.data.repository

import com.example.featureapp.data.local.dao.CashDao
import com.example.featureapp.data.local.entity.CashOperationEntity
import com.example.featureapp.domain.repository.CashRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CashRepositoryImpl @Inject constructor(private val dao: CashDao) : CashRepository {
    override suspend fun getAllCashOperation(): Flow<List<CashOperationEntity>> =
        dao.getAllCashOperation().map { list ->
            list.map {
                it
            }
        }

    override suspend fun insertCashOperation(operation: CashOperationEntity) =
        dao.insertCashOperation(operation)

    override suspend fun deleteOperation(operation: CashOperationEntity)= dao.deleteOperation(operation)

}