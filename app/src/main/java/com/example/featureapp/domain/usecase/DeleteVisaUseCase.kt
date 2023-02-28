package com.example.featureapp.domain.usecase

import com.example.featureapp.domain.model.VisaModel
import com.example.featureapp.domain.repository.VisaRepository

import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DeleteVisaUseCase @Inject constructor(private val repository: VisaRepository) {

    operator fun invoke(visa: VisaModel) = flow {
        emit(repository.deleteVisa(visa = visa))
    }
}