package br.com.framework.mvvm.koin.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.framework.mvvm.koin.data.model.DataModel

@Database(entities = arrayOf(DataModel::class), version = 1, exportSchema = false)
abstract class UserDataBase : RoomDatabase() {
    abstract val userDao: UserDao
}