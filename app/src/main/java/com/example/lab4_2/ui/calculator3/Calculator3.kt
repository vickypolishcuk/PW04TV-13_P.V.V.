package com.example.lab4_2.ui.calculator3

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
fun Calculator3(
    goBack: () -> Unit,
    calculatorsFunctions: CalculatorsFunctions
) {
    // Ініціалізація змінних
    var value1 by remember { mutableStateOf("") }
    var value2 by remember { mutableStateOf("") }
    var value3 by remember { mutableStateOf("") }
    var value4 by remember { mutableStateOf("") }
    var result1 by remember { mutableStateOf("") }
    var result2 by remember { mutableStateOf("") }
    var result3 by remember { mutableStateOf("") }
    var result4 by remember { mutableStateOf("") }
    var result5 by remember { mutableStateOf("") }
    var result6 by remember { mutableStateOf("") }
    var result7 by remember { mutableStateOf("") }
    var result8 by remember { mutableStateOf("") }

    // Функція обчислення результату
    fun calculate(): Unit {
        // Перетворення String на Double для подальших обчислень
        val formattedValue1 = value1.toDoubleOrNull() ?: 0.0;
        val formattedValue2 = value2.toDoubleOrNull() ?: 0.0;
        val formattedValue3 = value3.toDoubleOrNull() ?: 0.0;
        val formattedValue4 = value4.toDoubleOrNull() ?: 0.0;

        // Обчислення результатів
        val (list1, list2) = calculatorsFunctions.fun3(formattedValue1,
            formattedValue2, formattedValue3, formattedValue4)

        // Розпаковка списків
        val (res1, res2, res3, res4) = list1
        val (res5, res6, res7, res8) = list2

        // Присвоєння отриманих значень у раніше визначені змінні з 2 знаками після коми
        result1 = String.format("%.2f", res1)
        result2 = String.format("%.2f", res2)
        result3 = String.format("%.2f", res3)
        result4 = String.format("%.2f", res4)
        result5 = String.format("%.2f", res5)
        result6 = String.format("%.2f", res6)
        result7 = String.format("%.2f", res7)
        result8 = String.format("%.2f", res8)
    }

    // Інтерфейс сторінки
    Column(modifier = Modifier.padding(all = 15.dp)) {
        Text("До прикладу 3:")
        TextField(
            value = value1,
            onValueChange = { value1 = it },
            label = { Text("Нормальний режим опору (Rн)") },
            maxLines = 1,
        )
        TextField(
            value = value2,
            onValueChange = { value2 = it },
            label = { Text("Xн") },
            maxLines = 1,
        )
        TextField(
            value = value3,
            onValueChange = { value3 = it },
            label = { Text("Мінімальний режим опору (Rм)") },
            maxLines = 1,
        )
        TextField(
            value = value4,
            onValueChange = { value4 = it },
            label = { Text("Хм") },
            maxLines = 1,
        )
        Button(
            onClick = { calculate() }
        ) {
            Text("Обчислити")
        }
        // Веведення результатів
        if (result1.isNotEmpty() and result2.isNotEmpty()) {
            Text("Струм трифазного КЗ, нормальний режим: $result1")
            Text("Струм двофазного КЗ, нормальний режим: $result2")
            Text("Струм трифазного КЗ, мінімальний режим: $result3")
            Text("Струм двофазного КЗ, мінімальний режим: $result4")
            Text("Дійсний струм трифазного КЗ, нормальний режим: $result5")
            Text("Дійсний струм двофазного КЗ, нормальний режим: $result6")
            Text("Дійсний струм трифазного КЗ, мінімальний режим: $result7")
            Text("Дійсний струм двофазного КЗ, мінімальний режим: $result8")
            Text("Аварійний режим на даній підстанції не передбачений")
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