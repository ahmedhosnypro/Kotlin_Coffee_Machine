package machine

import machine.Coffee.calcIngredients
import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    println("Write how many cups of coffee you will need:")
    val cupsNum = scanner.nextInt()
    calcIngredients(cupsNum)
}
