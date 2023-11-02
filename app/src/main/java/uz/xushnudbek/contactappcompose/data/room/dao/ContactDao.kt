package uz.xushnudbek.contactappcompose.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import uz.xushnudbek.contactappcompose.data.room.entity.ContactEntity

@Dao
interface ContactDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addContact(contactEntity: ContactEntity)

    @Query("select * from contact")
    fun getAllContact(): Flow<List<ContactEntity>>

    @Delete
    fun delete(contactEntity: ContactEntity)

    @Update
    fun update(contactEntity: ContactEntity)
}