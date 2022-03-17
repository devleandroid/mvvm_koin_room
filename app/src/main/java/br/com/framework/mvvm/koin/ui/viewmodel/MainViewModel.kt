package br.com.framework.mvvm.koin.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import br.com.framework.mvvm.koin.data.db.UserDao
import br.com.framework.mvvm.koin.data.model.DataModel

class MainViewModel(private val userDao: UserDao): ViewModel() {
    fun getAllUser(): LiveData<List<DataModel>> = userDao.getAllUser()

    fun addUser(userAdd: DataModel){
        userDao.addUser(userAdd)
    }

    fun updateUser(id: Int, updateName: String, updateDesignation: String) {
        userDao.updateUser(id, updateName, updateDesignation)
    }

    fun deleteUser(userDelete: DataModel) {
        userDao.deleteUser(userDelete)
    }
}