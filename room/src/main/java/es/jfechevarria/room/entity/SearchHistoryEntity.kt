package es.jfechevarria.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "search_history", indices = [Index(value = ["query_text"], unique = true)])
internal data class SearchHistoryEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "query_text") val query: String,
    @ColumnInfo(name = "created_at") val createdAt: Date = Date()
)