package com.example.lab4_2.functions

import kotlin.math.pow
import kotlin.math.sqrt

class CalculatorsFunctions {
    fun fun1(num1:Double, num2: Double, num3: Double, num4: Double, num5: Double,
             num6: Double): Pair<Double, Double>{
        // Розрахунковий струм для нормального і після аварійного режимів
        val I1 = (num5 / 2) / (sqrt(3.0) * num1)
        val I2 = I1 * 2

        var j = 0.0 // економічна густина струму
        // Визначення економічної густини струму
        if (1000 < num6 && num6 < 3000) {
            j = 1.6
        } else if (3000 < num6 && num6 < 5000) {
            j = 1.4
        } else if (5000 < num6) {
            j = 1.2
        }

        // Обчислення результатів за наданими формулами
        val result1 = I1 / j
        val result2 = ((num2 * 1000) * sqrt(num3) / 92)

        return Pair(result1, result2)
    }
    fun fun2(num1: Int, num2: Int): Double {
        // Додаткові дані
        val Uc = 10.5
        val Snom = 6.3

        // Опори елементів
        val X1 = Uc.pow(2) / num2
        val X2 = (Uc / 100) * (Uc.pow(2) / Snom)

        // Сумарний опір для точки
        val Xres = X1 + X2

        // Обчислення початкового діючого значення струму (І)
        val result1 = Uc / (sqrt(3.0) * Xres)

        return result1
    }
    fun fun3(num1:Double, num2: Double, num3: Double, num4: Double):
            Pair<List<Double>, List<Double>> {
        // Додаткові значення
        val Un = 11.0
        val Uk = 11.1
        val Uv = 115.0
        val Snom = 6.3

        // Розрахунковий опір
        val Xt = (Uk * Uv.pow(2)) / (100 * Snom)

        // Розрахунок опору на шинах в нормальному режимі
        var Xsh = num2 + Xt
        var Zsh = sqrt(num1.pow(2) + Xsh.pow(2))

        // Розрахунок опору на шинах в мінімальному режимі
        var Xsh_min = num4 + Xt
        var Zsh_min = sqrt(num3.pow(2) + Xsh_min.pow(2))

        // Розрахунок струму трифазного КЗ в нормальному режимі
        var Ish_3 = (Uv * 10.0.pow(3)) / (sqrt(3.0) * Zsh)
        // Розрахунок струму двофазного КЗ в нормальному режимі
        var Ish_2 = Ish_3 * (sqrt(3.0) / 2)

        // Розрахунок струму трифазного КЗ в мінімальному режимі
        var Ish_3_min = (Uv * 10.0.pow(3)) / (sqrt(3.0) * Zsh_min)
        // Розрахунок струму двофазного КЗ в мінімальному режимі
        var Ish_2_min = Ish_3_min * (sqrt(3.0) / 2)

        val listOfRes: List<Double> = listOf(Ish_3, Ish_2, Ish_3_min, Ish_2_min)

        // Розрахунок коефіцієнта приведення для визначення дійсних струмів
        val k = (Un.pow(2)) / (Uv.pow(2))

        // Перерахунок опору на шинах в нормальному режимі
        val numNum1 = num1 * k
        Xsh *= k
        Zsh = sqrt(numNum1.pow(2) + Xsh.pow(2))

        // Перерахунок опору на шинах в мінімальному режимі
        val numNum3 = num3 * k
        Xsh_min *= k
        Zsh_min = sqrt(numNum3.pow(2) + Xsh_min.pow(2))

        // Розрахунок дійсного струму трифазного КЗ в нормальному режимі
        Ish_3 = (Un * 10.0.pow(3)) / (sqrt(3.0) * Zsh)
        // Розрахунок дійсного струму двофазного КЗ в нормальному режимі
        Ish_2 = Ish_3 * (sqrt(3.0) / 2)

        // Розрахунок дійсного струму трифазного КЗ в мінімальному режимі
        Ish_3_min = (Un * 10.0.pow(3)) / (sqrt(3.0) * Zsh_min)
        // Розрахунок дійсного струму двофазного КЗ в мінімальному режимі
        Ish_2_min = Ish_3_min * (sqrt(3.0) / 2)

        return Pair(listOfRes, listOf(Ish_3, Ish_2, Ish_3_min, Ish_2_min))
    }
}