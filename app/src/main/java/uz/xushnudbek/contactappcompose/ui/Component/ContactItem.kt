package uz.xushnudbek.contactappcompose.ui.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import uz.xushnudbek.contactappcompose.R
import uz.xushnudbek.contactappcompose.data.ContactData

@Composable
fun ContactItem(
    data: ContactData,
    onClickEdit: (ContactData) -> Unit,
    onCLickDelete: (ContactData) -> Unit
) {
    Row(
        modifier = Modifier
            .clickable(onClick = { onClickEdit(data) })
            .padding(8.dp)
            .background(color = MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        //Text(text = "${data.id}")
        Spacer(modifier = Modifier.size(8.dp))
        Column(
            modifier = Modifier
                .weight(0.7f, true)
        ) {

            Text(
                text = data.name,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.size(4.dp))

            Text(text = data.phone)

        }

        Column(modifier = Modifier.weight(0.3f)) {

        }

        Button(onClick = { onCLickDelete(data)}) {
            Text(text = "Delete")
        }
    }
}