package uz.xushnudbek.contactappcompose.domain.repository.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import uz.xushnudbek.contactappcompose.data.ContactData
import uz.xushnudbek.contactappcompose.data.room.dao.ContactDao
import uz.xushnudbek.contactappcompose.data.room.entity.toData
import uz.xushnudbek.contactappcompose.data.toEntity
import uz.xushnudbek.contactappcompose.domain.repository.AppRepository
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val contactDao: ContactDao
):AppRepository {
    override fun loadContacts(): Flow<List<ContactData>> = contactDao
        .getAllContact()
        .map {
            it.map { it.toData() }
        }
        .flowOn(Dispatchers.IO)
    override suspend fun addContact(contactData: ContactData)  = withContext(Dispatchers.IO){
        val entity = contactData.toEntity()
        contactDao.addContact(entity)
    }

    override suspend fun deleteContact(contactData: ContactData) = withContext(Dispatchers.IO){
        val entity = contactData.toEntity()
        contactDao.delete(entity)
    }

    override suspend fun editContact(contactData: ContactData) = withContext(Dispatchers.IO){
        val entity = contactData.toEntity()
        contactDao.update(entity)
    }
}