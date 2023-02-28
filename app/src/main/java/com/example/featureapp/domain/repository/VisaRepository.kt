package com.example.featureapp.domain.repository
import com.example.featureapp.domain.model.VisaModel
import kotlinx.coroutines.flow.Flow


interface VisaRepository {

   suspend fun getAllVisa(): Flow<List<VisaModel>>


    suspend fun getVisaById(id: Int): VisaModel?


    suspend fun insertVisa(visa: VisaModel)


    suspend fun deleteVisa(visa: VisaModel)
}