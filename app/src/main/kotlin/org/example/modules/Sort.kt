package org.example.modules
import kotlin.system.measureNanoTime

//bubble sort
fun bubbleSort(arr: IntArray) {
    //tamaño del array
    val n = arr.size
    //itera sobre el array
    for (i in 0 until n - 1) {
        //itera sobre el array
        for (j in 0 until n - i - 1) {
            //si el valor actual es mayor al siguiente
            if (arr[j] > arr[j + 1]) {
                //intercambia los valores
                // swap arr[j+1] and arr[j]
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }
}

//quick sort
fun quickSort(arr: IntArray, low: Int, high: Int) {
    if (low < high) {
        //particiona el array
        val pi = partition(arr, low, high)
        //aplica recursion usando divide y venceras
        quickSort(arr, low, pi - 1)
        quickSort(arr, pi + 1, high)
    }
}

//se encarga de ordenar los valores mayores a la derecha y menores a la izquierda
fun partition(arr: IntArray, low: Int, high: Int): Int {
    //elemento de pivote
    val pivot = arr[high]
    //inicializa el índice de comparación
    var i = low - 1
    //itera sobre el array
    for (j in low until high) {
        //si el valor actual es menor al pivote
        if (arr[j] < pivot) {
            //incrementa el índice de comparación
            i++
            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
        }
    }
    //intercambia los valores
    val temp = arr[i + 1]
    arr[i + 1] = arr[high]
    arr[high] = temp
    return i + 1
}

fun measureTime(algoritmo: (IntArray) -> Unit, arr: IntArray): Double {
    return measureNanoTime {
        algoritmo(arr)
    } / 1000000000.0  // Convierte nanosegundos a segundos
}   



