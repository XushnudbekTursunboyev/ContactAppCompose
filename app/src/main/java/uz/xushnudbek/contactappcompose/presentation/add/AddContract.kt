package uz.xushnudbek.contactappcompose.presentation.add

import kotlinx.coroutines.flow.StateFlow
import uz.xushnudbek.contactappcompose.data.ContactData


interface AddContract {
    interface AddViewModel {
        fun onEventDispatcher(intent: Intent)
    }

    interface Intent {
        data class ClickAdd(
            val data: ContactData
        ) : Intent
    }
}