package com.example.lab4_2.ui.calculator2

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lab4_2.functions.CalculatorsFunctions

@Composable
fun Calculator2(
    goBack: () -> Unit,
    calculatorsFunctions: CalculatorsFunctions
) {
    // Ініціалізація змінних
    var value1 by remember { mutableStateOf("") }
    var value2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    // Функція обчислення результату
    fun calculate(): Unit {
        // Перетворення String на Int для подальших обчислень
        val formattedValue1 = value1.toIntOrNull() ?: 0;
        val formattedValue2 = value2.toIntOrNull() ?: 0;

        // Обчислення результату
        val res = calculatorsFunctions.fun2(formattedValue1, formattedValue2)
        // Перетворення результату на тип String з 2 знаками після коми
        result = String.format("%.2f", res)
    }

    Column(modifier = Modifier.padding(all = 15.dp)) {
        Text("До прикладу 2:")
        TextField(
            value = value1,
            onValueChange = { value1 = it },
            label = { Text("Шини ГПП:") },
            maxLines = 1,
        )
        TextField(
            value = value2,
            onValueChange = { value2 = it },
            label = { Text("Потужність КЗ:") },
            maxLines = 1,
        )
        Button(
            onClick = { calculate() }
        ) {
            Text("Обчислити")
        }
        // Веведення результату
        if (result.isNotEmpty()) {
            Text("Значення струму трифазного КЗ становить $result")
        }
        // Кнопка для повернення на головний екран
        Box(
            modifier = Modifier.fillMaxSize().padding(top = 100.dp)
        ) {
            Button(
                onClick = goBack,
                modifier = Modifier.align(Alignment.Center) // Розміщення кнопки в центрі
            ) {
                Text("На головну")
            }
        }
    }
}