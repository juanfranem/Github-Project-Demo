package es.jfechevarria.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import es.jfechevarria.room.converters.DateConverter
import es.jfechevarria.room.dao.SearchHistoryDao
import es.jfechevarria.room.entity.SearchHistoryEntity

@Database(entities = [SearchHistoryEntity::class], version = 1)
@TypeConverters(DateConverter::class)
internal abstract class AppDatabase: RoomDatabase() {
    abstract fun searchHistoryDao(): SearchHistoryDao
}