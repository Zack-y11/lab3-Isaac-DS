package org.example.modules

object HanoiCounter {
    var pasos = 0
    fun reset() {
        pasos = 0
    }
}
//funcion recursiva hanoi
fun hanoi(discos: Int, origen: String, objetivo: String, auxiliar: String) {
    //si solo hay un disco, se mueve directamente al objetivo
    if (discos == 1) {
        HanoiCounter.pasos++
        println("Paso ${HanoiCounter.pasos}: Mover disco 1 de $origen a $objetivo")
        return
    }
    //sino, se llama a la funcion recursivamente
    //con los discos n-1 en el auxiliar
    hanoi(discos - 1, origen, auxiliar, objetivo)
    HanoiCounter.pasos++
    println("Paso ${HanoiCounter.pasos}: Mover disco $discos de $origen a $objetivo")
    hanoi(discos - 1, auxiliar, objetivo, origen)
}

//funcion recursiva: factorial
fun factorial(n: Int): Int {
    // si es 0 retorna 1
    return if (n == 0) {
        1
    } else {
        //sino, continuara llamando a la funcion
        //resta uno al numero del input, hasta llegar al final
        //y multiplicara el numero del input por el resultado de la funcion
        n * factorial(n - 1)
    }
}
