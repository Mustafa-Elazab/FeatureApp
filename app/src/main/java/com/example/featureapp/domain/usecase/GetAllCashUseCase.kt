package com.example.featureapp.domain.usecase

import com.example.featureapp.domain.repository.CashRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllCashUseCase @Inject constructor(private val repository: CashRepository) {

    operator fun invoke() = flow {
        emit(repository.getAllCashOperation())
    }
}