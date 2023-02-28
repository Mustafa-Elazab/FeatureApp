package com.example.featureapp.domain.usecase

import com.example.featureapp.domain.model.VisaModel
import com.example.featureapp.domain.repository.VisaRepository
import javax.inject.Inject

class AddVisaUseCase @Inject constructor(private val repository: VisaRepository) {

    suspend operator fun invoke(visa: VisaModel) {
        repository.insertVisa(visa = visa)
    }
}