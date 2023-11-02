package uz.xushnudbek.contactappcompose.presentation.add

import uz.xushnudbek.contactappcompose.data.ContactData
import uz.xushnudbek.contactappcompose.presentation.add.AddScreen
import uz.xushnudbek.contactappcompose.presentation.edit.EditScreen
import uz.xushnudbek.contactappcompose.utils.navigator.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

interface AddDirection {
    suspend fun back()
}

@Singleton
class AddDirectionImpl @Inject constructor(
    private val appNavigator: AppNavigator
) : AddDirection {
    override suspend fun back() {
        appNavigator.back()
    }

}