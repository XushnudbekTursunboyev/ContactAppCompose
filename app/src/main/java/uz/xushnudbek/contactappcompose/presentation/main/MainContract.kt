package uz.xushnudbek.contactappcompose.presentation.main

import kotlinx.coroutines.flow.StateFlow
import uz.xushnudbek.contactappcompose.data.ContactData


interface MainContract {
    interface MainViewModel {
        val uiState: StateFlow<UIState>
        fun onEventDispatcher(intent: Intent)
    }

    data class UIState(
        val state: List<ContactData> = listOf()
    )

    interface Intent {
        data class ClickEdit(
            val data: ContactData
        ) : Intent

        data class ClickDelete(
            val data: ContactData
        ):Intent

        object ClickAdd:Intent
    }
}