package com.mhdsuhail.ratemyproperty.data.room

import androidx.room.*

@Dao
interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg obj: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    suspend fun insertAll(obj: List<T>)

    @Update
    suspend fun update(vararg obj: T)

    @Delete
    suspend fun delete(vararg obj: T)

}