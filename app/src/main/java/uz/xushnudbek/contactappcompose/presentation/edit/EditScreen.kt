package uz.xushnudbek.contactappcompose.presentation.edit

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import uz.xushnudbek.contactappcompose.data.ContactData
import uz.xushnudbek.contactappcompose.presentation.add.AddContract
import uz.xushnudbek.contactappcompose.ui.theme.ContactAppComposeTheme

class EditScreen(private val data: ContactData) : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewmodel: EditContract.EditViewModel = getViewModel<EditViewModelImpl>()
        EditScreenContent(
            data = data,
            onIntent = viewmodel::onEventDispatcher
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun EditScreenContent(
    data: ContactData,
    onIntent: (EditContract.Intent) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        var name by remember { mutableStateOf(data.name) }
        var phone by remember { mutableStateOf(data.phone) }
        Column(modifier = Modifier.fillMaxWidth()) {
            TextField(value = name, onValueChange = {
                name = it
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .background(color = Color.Cyan), shape = RoundedCornerShape(5.dp)
            )

            TextField(value = phone, onValueChange = {
                phone = it
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .background(color = Color.Cyan), shape = RoundedCornerShape(5.dp)
            )

            Button(onClick = {onIntent.invoke(EditContract.Intent.ClickEdit(ContactData(data.id, name, phone)))}, modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)) {
                Text(text = "Edit")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EditScreenPreview() {
    ContactAppComposeTheme {
        EditScreenContent(data = ContactData(0, "", "")){}
    }
}