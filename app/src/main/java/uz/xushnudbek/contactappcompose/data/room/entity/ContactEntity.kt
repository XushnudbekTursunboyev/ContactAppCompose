package uz.xushnudbek.contactappcompose.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import uz.xushnudbek.contactappcompose.data.ContactData

@Entity(tableName = "contact")
data class ContactEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int =0,
    val name:String,
    val phone:String
)

fun ContactEntity.toData(): ContactData = ContactData(id, name, phone)
