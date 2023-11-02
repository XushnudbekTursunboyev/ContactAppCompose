package uz.xushnudbek.contactappcompose.presentation.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import uz.xushnudbek.contactappcompose.ui.Component.ContactItem
import uz.xushnudbek.contactappcompose.ui.theme.ContactAppComposeTheme

class MainScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel: MainContract.MainViewModel = getViewModel<MainViewModelImpl>()
        MainContent(
            uiState = viewModel.uiState.collectAsState(), onIntent = viewModel::onEventDispatcher
        )
    }
}

@Composable
private fun MainContent(
    uiState: State<MainContract.UIState>,
    onIntent: (MainContract.Intent) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        FloatingActionButton(onClick = { onIntent.invoke(MainContract.Intent.ClickAdd) }, modifier = Modifier.align(Alignment.BottomEnd).padding(12.dp)) {}

        LazyColumn{
            items(uiState.value.state) {
                ContactItem(
                    data = it,
                    onClickEdit = {onIntent.invoke(MainContract.Intent.ClickEdit(it))},
                    onCLickDelete = {onIntent.invoke(MainContract.Intent.ClickDelete(it))}
                )
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
private fun MainContentPreview() {
    ContactAppComposeTheme {
        MainContent(uiState = mutableStateOf(MainContract.UIState())) {}
    }
}