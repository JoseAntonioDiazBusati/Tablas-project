/**
 * Solicita un número entero en un rango.
 *
 * @param min Int - valor mínimo
 * @param max Int - valor máximo
 *
 * @return Int - número entero válido dentro del rango especificado
 */
fun pedirNum(min:Int, max:Int): Int{
    var num = 0
    var salir = false
    while (!salir){
        println("Introduce un numero $min y $max: ")
        try {
            num = readlnOrNull()?.toInt()!!
            if (num in min..max){
                salir = true
            } else {
                println("Error!!! Numero no válido")
                println("Pulse ENTER para continuar...")
                readln()
            }
        }catch (e: NumberFormatException){
            println("Error!!! Respuesta no válida")
            println("Pulse ENTER para continuar...")
            readln()
        }
    }
    return num
}

/**
 * Realiza una pregunta para contestar con s/si ó n/no
 *
 * @param text String - Texto de la pregunta
 *
 * @return Boolean - true/false dependiendo de la respuesta válida a la pregunta
 */
fun pregunta(text: String): Boolean{
    val si = true
    while (si){
        println(text)
        try {
            when(readlnOrNull()){
                "s" -> return true
                "n" -> return false
                else -> {
                    println("Error!!! Respuesta no válida debe ser s/n")
                    println("Pulse ENTER para continuar...")
                    readln()
                }
            }
        }catch (e:Exception){
            println("Error!!! Respuesta no válida. Por favor deje de hacer esto")
            println("Pulse ENTER para continuar...")
            readln()
        }
    }
    return si
}

fun main() {
    //TODO: Solicitar la introducción de un número entre 1 y 100 y mostrar su table de multiplicar...
    //Hasta que se responda negativamente a la pregunta "¿Desea generar otra tabla de multiplicación? (s/n)"
    val text = "¿Desea generar otra tabla?"
    var resp = true
    while (resp){
        val num = pedirNum(1, 100)
        for(i in 1..10){
            println("$i -> $num x $i = ${num * i}")
        }
        resp = pregunta(text)
    }
    println("Programa terminado.(Se acabó!!!)")
}