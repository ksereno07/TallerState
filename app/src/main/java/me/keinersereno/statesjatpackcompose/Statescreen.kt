package me.keinersereno.statesjatpackcompose

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showSystemUi = true)
@Composable
fun Statescreen() {

    // Lista con los 6 recursos de las caras del dado
    // (deben estar en res/drawable como dice_1.xml ... dice_6.xml)
    val diceImages = listOf(
        R.drawable.dice_1,
        R.drawable.dice_2,
        R.drawable.dice_3,
        R.drawable.dice_4,
        R.drawable.dice_5,
        R.drawable.dice_6
    )

    // Estado: número actual mostrado en el dado
    var diceNumber by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Número: $diceNumber", fontSize = 32.sp)
        Spacer(modifier = Modifier.height(25.dp))

        Image(
            painter = painterResource(id = diceImages[diceNumber - 1]),
            contentDescription = "Dado mostrando el número $diceNumber",
            modifier = Modifier.height(200.dp)
        )
        Spacer(modifier = Modifier.height(25.dp))

        Button(onClick = {
            Log.i("mis-errores", "Estoy dando click")
            diceNumber = (1..6).random()
        }) {
            Text("Lanzar dado")
        }
    }
}