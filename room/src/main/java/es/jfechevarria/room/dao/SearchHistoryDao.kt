package es.jfechevarria.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import es.jfechevarria.room.entity.SearchHistoryEntity

@Dao
internal interface SearchHistoryDao {

    @Query("Delete from search_history")
    fun deleteAll()

    @Insert
    fun insert(vararg searchHistory: SearchHistoryEntity)

    @Query("Select * from search_history order by created_at desc limit 10")
    fun getSearchHistory(): List<SearchHistoryEntity>

}