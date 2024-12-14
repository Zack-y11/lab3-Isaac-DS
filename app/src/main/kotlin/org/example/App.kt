package org.example

import org.example.modules.bubbleSort
import org.example.modules.factorial
import org.example.modules.hanoi
import org.example.modules.measureTime
import org.example.modules.quickSort
import org.example.modules.HanoiCounter

class App {}

fun main() {
    var running = true
    while (running) {
        println("\nSeleccione una opción:")
        println("1. Ordenar Usando Bubble Sort")
        println("2. Ordenar Usando Quick Sort")
        println("3. Obtener Factorial")
        println("4. Resolver Torres de Hanoi")
        println("5. Salir")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                println("Ingrese una lista de numeros separados por comas:")
                try {
                    //convierte el input en un array de numeros
                    val arr =
                            readLine()?.split(",")?.map { it.toInt() }?.toIntArray() ?: intArrayOf()

                    //si la lista esta vacia, muestra un mensaje de error
                    if (arr.isEmpty()) {
                        println("La lista no puede estar vacía")
                        continue
                    }
                    println("original: ${arr.joinToString()}")
                    val tiempo = measureTime(::bubbleSort, arr)
                    bubbleSort(arr)
                    println("Lista ordenada por BubbleSort: ${arr.joinToString()}")
                    println("Tiempo de ejecución: %.6f segundos".format(tiempo))
                } catch (e: NumberFormatException) {
                    println("Error: Ingrese una lista de números válida")
                }
            }
            2 -> {
                println("Ingrese una lista de numeros separados por comas:")
                try {
                    //convierte el input en una array
                    val arr =
                            readLine()?.split(",")?.map { it.toInt() }?.toIntArray() ?: intArrayOf()
                    //si la lista esta vacia, muestra un mensaje de error
                    if (arr.isEmpty()) {
                        println("La lista no puede estar vacía")
                        continue
                    }
                    println("original: ${arr.joinToString()}")
                    val tiempo = measureTime({ array -> quickSort(array, 0, array.size - 1) }, arr)
                    quickSort(arr, 0, arr.size - 1)
                    println("Lista ordenada por QuickSort: ${arr.joinToString()}")
                    println("Tiempo de ejecución: %.6f segundos".format(tiempo))
                } catch (e: NumberFormatException) {
                    println("Error: Ingrese una lista de números válida")
                }
            }
            3 -> {
                println("Ingrese un número para calcular su factorial:")
                val input = readLine()?.toIntOrNull()
                try {
                    //valida que no sea null
                    if (input != null) {
                        //se asegura que no sea negativo
                        if (input < 0) {
                            println(
                                    "Error: No se puede calcular el factorial de un número negativo"
                            )
                            continue
                        }
                        val resultado = factorial(input)
                        println("El factorial de $input es: $resultado")
                    } else {
                        println("Error: Por favor ingrese un número válido")
                    }
                } catch (e: IllegalArgumentException) {
                    println("Error: ${e.message}")
                }
            }
            4 -> {
                print("Ingrese el número de discos: ")
                var numDiscos = readLine()?.toIntOrNull() ?: 0
                while (numDiscos <= 0) {
                    print("Error: Ingrese un número de discos válido (mayor que 0): ")
                    numDiscos = readLine()?.toIntOrNull() ?: 0
                }
                try {
                    println("\nPasos para resolver Torres de Hanoi con $numDiscos discos:")
                    HanoiCounter.reset()
                    hanoi(numDiscos, "A", "B", "C")
                } catch (e: IllegalArgumentException) {
                    println("Error: ${e.message}")
                }
            }
            5 -> {
                println("¡Gracias por usar el programa!")
                running = false
            }
            else -> {
                println("Error: Opción no válida. Por favor, seleccione una opción entre 1 y 5")
            }
        }
    }
}
