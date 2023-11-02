package uz.xushnudbek.contactappcompose.presentation.add

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
class AddViewModelImpl @Inject constructor(
    private val repository: AppRepository,
    private val direction: AddDirection
) : ViewModel(), AddContract.AddViewModel {

    override fun onEventDispatcher(intent: AddContract.Intent) {
        when(intent){
            is AddContract.Intent.ClickAdd -> {
                viewModelScope.launch {
                    repository.addContact(intent.data)
                    direction.back()
                }
            }
        }
    }
}