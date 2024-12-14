fun <T> measureTime(block: (T) -> Unit, param: T): Double {
    val time = kotlin.system.measureNanoTime {
        block(param)
    }
    return time / 1_000_000.0  // Convertir nanosegundos a milisegundos para mostrar
} 