package uz.xushnudbek.contactappcompose.presentation.edit

import uz.xushnudbek.contactappcompose.data.ContactData
import uz.xushnudbek.contactappcompose.presentation.add.AddScreen
import uz.xushnudbek.contactappcompose.presentation.edit.EditScreen
import uz.xushnudbek.contactappcompose.utils.navigator.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

interface EditDirection {
    suspend fun back()
}

@Singleton
class EditDirectionImpl @Inject constructor(
    private val appNavigator: AppNavigator
) : EditDirection {
    override suspend fun back() {
        appNavigator.back()
    }
}