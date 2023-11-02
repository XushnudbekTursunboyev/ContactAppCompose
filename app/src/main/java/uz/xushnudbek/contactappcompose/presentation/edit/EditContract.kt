package uz.xushnudbek.contactappcompose.presentation.edit

import kotlinx.coroutines.flow.StateFlow
import uz.xushnudbek.contactappcompose.data.ContactData


interface EditContract {
    interface EditViewModel {
        fun onEventDispatcher(intent: Intent)
    }

    interface Intent {
        data class ClickEdit(
            val data: ContactData
        ) : Intent
    }
}