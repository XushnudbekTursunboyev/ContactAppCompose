package uz.xushnudbek.contactappcompose.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.xushnudbek.contactappcompose.data.room.dao.ContactDao
import uz.xushnudbek.contactappcompose.data.room.entity.ContactEntity

@Database(entities = [ContactEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDao
}