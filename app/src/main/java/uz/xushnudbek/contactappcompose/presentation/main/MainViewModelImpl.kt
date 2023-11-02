package uz.xushnudbek.contactappcompose.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import uz.xushnudbek.contactappcompose.domain.repository.AppRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModelImpl @Inject constructor(
    private val repository: AppRepository,
    private val direction: MainDirection
) : ViewModel(), MainContract.MainViewModel {
    override val uiState = MutableStateFlow(MainContract.UIState())

    private fun reduce(block: MainContract.UIState.() -> MainContract.UIState) {
        val oldState = uiState.value
        val newState = block(oldState)
        uiState.tryEmit(newState)
    }

    init {
        repository.loadContacts()
            .onEach {
                reduce { this.copy(state = it) }
            }.launchIn(viewModelScope)
    }

    override fun onEventDispatcher(intent: MainContract.Intent) {
        when (intent) {
            MainContract.Intent.ClickAdd -> {
                viewModelScope.launch {
                    direction.openAddScreen()
                }
            }

            is MainContract.Intent.ClickEdit -> {
                viewModelScope.launch {
                    direction.openEditScreen(intent.data)
                }
            }

            is MainContract.Intent.ClickDelete -> {
                viewModelScope.launch { repository.deleteContact(intent.data) }
            }
        }
    }
}