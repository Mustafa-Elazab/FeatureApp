package com.example.featureapp.di

import android.content.Context
import androidx.room.Room
import com.example.featureapp.data.local.dao.CashDao
import com.example.featureapp.data.local.dao.VisaDao
import com.example.featureapp.data.local.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideVisaDao(appDatabase: AppDatabase): VisaDao = appDatabase.visaDao()


    @Singleton
    @Provides
    fun provideCashDao(appDatabase: AppDatabase): CashDao = appDatabase.cashOperationDao()


    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "app-db"
    ).build()



}