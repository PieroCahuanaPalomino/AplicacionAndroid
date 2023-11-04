package com.project.condosa.ui.components.view.Initial

import android.app.Dialog
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.condosa.R

@Composable
fun Dialog(
    showDialog: Boolean,
    dismissDialog: () -> Unit
) {
    val redPaletCircleColor = colorResource(id = R.color.redPaletCircle) // Obtener el color de color.xml

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { dismissDialog() },
            title = {
                Text(
                    "Título del Diálogo",
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            },
            text = {
                Column {
                    Text("Fila 1")
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("Fila 2")
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("Fila 3")
                }
            },
            confirmButton = {
                Button(
                    onClick = { dismissDialog() },
                    colors = ButtonDefaults.buttonColors(backgroundColor = redPaletCircleColor) // Cambia el color de fondo aquí
                ) {
                    Text("Cerrar", color = Color.White) // Cambia el color del texto aquí
                }
            },
            dismissButton = {
                Button(onClick = { dismissDialog() }) {
                    Text("Cancelar")
                }
            }
        )
    }
}
