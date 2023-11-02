package uz.xushnudbek.contactappcompose.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.xushnudbek.contactappcompose.data.ContactData

interface AppRepository {
    fun loadContacts(): Flow<List<ContactData>>

    suspend fun addContact(contactData: ContactData)
    suspend fun deleteContact(contactData: ContactData)
    suspend fun editContact(contactData: ContactData)
}