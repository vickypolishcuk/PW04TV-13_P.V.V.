package com.example.lab4_2.ui.firstScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lab4_2.ui.theme.PurpleGrey40


val buttonStyles = Modifier.padding(all = 30.dp)

@Composable
fun FirstScreen(
    onCalculator1Navigate: () -> Unit,
    onCalculator2Navigate: () -> Unit,
    onCalculator3Navigate: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center // Центрування вмісту
    ) {
        Column(
            modifier = buttonStyles,
            verticalArrangement = Arrangement.spacedBy(50.dp), // Відступ між кнопками
            horizontalAlignment = Alignment.CenterHorizontally // Центрування кнопки по горизонталі
        ) {
            // Кнопка 1
            Button(
                onClick = { onCalculator1Navigate() },
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = PurpleGrey40
                )
            ) {
                Text(
                    text = "Калькулятор 1"
                )
            }
            // Кнопка 2
            Button(
                onClick = onCalculator2Navigate,
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = PurpleGrey40
                )
            ) {
                Text(
                    text = "Калькулятор 2"
                )
            }
            // Кнопка 3
            Button(
                onClick = onCalculator3Navigate,
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = PurpleGrey40
                )
            ) {
                Text(
                    text = "Калькулятор 3"
                )
            }
        }
    }
}