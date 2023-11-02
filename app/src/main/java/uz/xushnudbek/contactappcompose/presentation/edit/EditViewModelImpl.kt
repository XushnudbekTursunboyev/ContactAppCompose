package uz.xushnudbek.contactappcompose.presentation.edit

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
class EditViewModelImpl @Inject constructor(
    private val repository: AppRepository,
    private val direction: EditDirection
) : ViewModel(), EditContract.EditViewModel {

    override fun onEventDispatcher(intent: EditContract.Intent) {
        when(intent){
            is EditContract.Intent.ClickEdit -> {
                viewModelScope.launch {
                    repository.editContact(intent.data)
                    direction.back()
                }
            }
        }
    }
}