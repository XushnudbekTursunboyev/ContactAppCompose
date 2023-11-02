package uz.xushnudbek.contactappcompose.data

import uz.xushnudbek.contactappcompose.data.room.entity.ContactEntity
import java.io.Serializable

data class ContactData(
    val id:Int,
    val name:String,
    val phone:String
):Serializable

fun ContactData.toEntity():ContactEntity = ContactEntity(id, name, phone)