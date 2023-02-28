package com.example.featureapp.domain.usecase

import com.example.featureapp.domain.model.VisaModel
import com.example.featureapp.domain.repository.VisaRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllVisaUseCase @Inject constructor(private val repository: VisaRepository){


    operator fun invoke() = flow {
        emit(repository.getAllVisa())
    }
}