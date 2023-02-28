package com.example.featureapp.data.repository


import com.example.featureapp.data.local.dao.VisaDao
import com.example.featureapp.data.mapper.toEntity
import com.example.featureapp.data.mapper.toModel
import com.example.featureapp.domain.model.VisaModel
import com.example.featureapp.domain.repository.VisaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VisaRepositoryImpl @Inject constructor(
    private val dao: VisaDao,
) : VisaRepository {

    override suspend fun getAllVisa(): Flow<List<VisaModel>> =
        dao.getAllVisa().map { visa ->
            visa.map {
                it.toModel()
            }

        }


    override suspend fun getVisaById(id: Int): VisaModel? {
        return dao.getVisaById(id)?.toModel()
    }

    override suspend fun insertVisa(visa: VisaModel) {


        dao.insertVisa(visa.toEntity())


    }

    override suspend fun deleteVisa(visa: VisaModel) {


        dao.deleteVisa(visa.toEntity())


    }


}