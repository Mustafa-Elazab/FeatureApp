package com.example.featureapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.featureapp.data.local.dao.CashDao
import com.example.featureapp.data.local.dao.VisaDao
import com.example.featureapp.data.local.entity.CashOperationEntity
import com.example.featureapp.data.local.entity.VisaEntity


@Database(
    entities = [VisaEntity::class, CashOperationEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun visaDao(): VisaDao
    abstract fun cashOperationDao(): CashDao

}
