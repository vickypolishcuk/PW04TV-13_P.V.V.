package com.example.lab4_2.ui.calculator1

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
fun Calculator1(
    goBack: () -> Unit,
    calculatorsFunctions: CalculatorsFunctions
) {
    // Ініціалізація змінних
    var value1 by remember { mutableStateOf("") }
    var value2 by remember { mutableStateOf("") }
    var value3 by remember { mutableStateOf("") }
    var value4 by remember { mutableStateOf("") }
    var value5 by remember { mutableStateOf("") }
    var value6 by remember { mutableStateOf("") }
    var result1 by remember { mutableStateOf("") }
    var result2 by remember { mutableStateOf("") }

    // Функція обчислення результату
    fun calculate(): Unit {
        // Перетворення String на Double для подальших обчислень
        val formattedValue1 = value1.toDoubleOrNull() ?: 0.0;
        val formattedValue2 = value2.toDoubleOrNull() ?: 0.0;
        val formattedValue3 = value3.toDoubleOrNull() ?: 0.0;
        val formattedValue4 = value4.toDoubleOrNull() ?: 0.0;
        val formattedValue5 = value5.toDoubleOrNull() ?: 0.0;
        val formattedValue6 = value6.toDoubleOrNull() ?: 0.0;

        // Обчислення результатів
        val (res1, res2) = calculatorsFunctions.fun1(formattedValue1, formattedValue2,
            formattedValue3, formattedValue4, formattedValue5, formattedValue6)

        // Присвоєння отриманих значень у раніше визначені змінні з 2 знаками після коми
        result1 = String.format("%.2f", res1)
        result2 = String.format("%.2f", res2)
    }

    // Інтерфейс сторінки
    Column(modifier = Modifier.padding(all = 15.dp)) {
        Text("До прикладу 1:")
        TextField(
            value = value1,
            onValueChange = { value1 = it },
            label = { Text("Напруга (кВ)") },
            maxLines = 1,
        )
        TextField(
            value = value2,
            onValueChange = { value2 = it },
            label = { Text("Струм КЗ (Iк)") },
            maxLines = 1,
        )
        TextField(
            value = value3,
            onValueChange = { value3 = it },
            label = { Text("Фіктивний час виконання (tф)") },
            maxLines = 1,
        )
        TextField(
            value = value4,
            onValueChange = { value4 = it },
            label = { Text("Потужність ТП") },
            maxLines = 1,
        )
        TextField(
            value = value5,
            onValueChange = { value5 = it },
            label = { Text("Розрахункове навантаження (Sm)") },
            maxLines = 1,
        )
        TextField(
            value = value6,
            onValueChange = { value6 = it },
            label = { Text("Тм") },
            maxLines = 1,
        )
        Button(
            onClick = { calculate() }
        ) {
            Text("Обчислити")
        }
        // Веведення результатів
        if (result1.isNotEmpty() and result2.isNotEmpty()) {
            Text("Броньований кабель: $result1")
            Text("ААБ кабель: $result2")
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