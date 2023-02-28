package com.example.featureapp.di

import com.example.featureapp.data.repository.CashRepositoryImpl
import com.example.featureapp.data.repository.VisaRepositoryImpl
import com.example.featureapp.domain.repository.CashRepository
import com.example.featureapp.domain.repository.VisaRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {


    @Binds
    abstract fun bindVisaRepository(repository: VisaRepositoryImpl): VisaRepository


    @Binds
    abstract fun bindCashRepository(repositoryImpl: CashRepositoryImpl): CashRepository

}