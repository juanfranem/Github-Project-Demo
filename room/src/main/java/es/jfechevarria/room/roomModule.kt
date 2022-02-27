package es.jfechevarria.room

import androidx.room.Room
import androidx.room.RoomDatabase
import es.jfechevarria.domain.searchHistory.dataSource.SearchHistoryDataSource
import es.jfechevarria.room.dao.SearchHistoryDao
import es.jfechevarria.room.datasource.SearchHistoryDataSourceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val roomModule = module {
    single<AppDatabase> { Room.databaseBuilder(androidContext(), AppDatabase::class.java,
    androidContext().packageName + ".db").build() }

    factory<SearchHistoryDao> { get<AppDatabase>().searchHistoryDao() }

    factory<SearchHistoryDataSource> { SearchHistoryDataSourceImpl(get()) }
}