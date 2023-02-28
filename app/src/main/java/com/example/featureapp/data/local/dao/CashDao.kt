package com.example.featureapp.data.local.dao

import androidx.room.*
import com.example.featureapp.data.local.entity.CashOperationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CashDao {


    @Query("SELECT * FROM cashoperationentity")
     fun getAllCashOperation(): Flow<List<CashOperationEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCashOperation(operation: CashOperationEntity)

    @Delete
    suspend fun deleteOperation(operation: CashOperationEntity)

}