package br.com.framework.mvvm.koin.di

import android.app.Application
import androidx.room.Room
import br.com.framework.mvvm.koin.data.db.UserDao
import br.com.framework.mvvm.koin.data.db.UserDataBase
import br.com.framework.mvvm.koin.ui.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val userDB = module {
    fun provideDataBase(application: Application): UserDataBase {
        return Room.databaseBuilder(application, UserDataBase::class.java, "USER_DB")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideDao(dataBase: UserDataBase): UserDao {
        return dataBase.userDao
    }

    single { provideDataBase(androidApplication()) }
    single { provideDao(get()) }

}

val mainViewModel = module {
    viewModel { MainViewModel(get()) }
}