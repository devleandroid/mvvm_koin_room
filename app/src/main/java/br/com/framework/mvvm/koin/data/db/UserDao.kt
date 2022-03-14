package br.com.framework.mvvm.koin.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import br.com.framework.mvvm.koin.data.model.DataModel

@Dao
interface UserDao {
    @Query("select * from user_table")
    fun getAllUser(): LiveData<List<DataModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(addUser: DataModel)

    @Query("update user_table set fullName =:updateName, designation=:updateDesignation where userId=:id")
    fun updateUser(id: Int, updateName: String, updateDesignation: String)

    @Delete
    fun deleteUser(deleteUser: DataModel)
}