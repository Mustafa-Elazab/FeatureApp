package com.example.featureapp.domain.usecase

import com.example.featureapp.domain.model.VisaModel
import com.example.featureapp.domain.repository.VisaRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetVisaUseCase @Inject constructor(private val repository: VisaRepository) {

    operator fun invoke(id: Int) = flow {
        emit(repository.getVisaById(id = id))
    }
}