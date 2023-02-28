package com.example.featureapp.domain.usecase

import com.example.featureapp.data.local.entity.CashOperationEntity
import com.example.featureapp.domain.repository.CashRepository
import javax.inject.Inject

class AddCashUseCase @Inject constructor(private val repository: CashRepository) {

    suspend operator fun invoke(operationModel: CashOperationEntity) {
        repository.insertCashOperation(operation = operationModel)
    }
}