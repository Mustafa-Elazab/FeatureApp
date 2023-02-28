package com.example.featureapp.data.local.dao
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.featureapp.data.local.entity.VisaEntity

import kotlinx.coroutines.flow.Flow

@Dao
interface VisaDao {
    @Query("SELECT * FROM visa")
    fun getAllVisa(): Flow<List<VisaEntity>>

    @Query("SELECT * FROM visa WHERE id = :id")
    suspend fun getVisaById(id: Int): VisaEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVisa(visa: VisaEntity)

    @Delete
    suspend fun deleteVisa(visa: VisaEntity)

//    @Query("SELECT * FROM notes WHERE note_text LIKE '%' || :search || '%' OR subtitle LIKE '%' || :search || '%' OR note_text LIKE '%' || :search || '%'")
//    fun search(search:String): Flow<List<NoteEntity>>


}