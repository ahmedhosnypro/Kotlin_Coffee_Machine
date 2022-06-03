package machine

import java.util.*

open class Coffee {
    companion object {
        private var scanner = Scanner(System.`in`)

        fun calcNumberOfServings() {
            println("Write how many ml of water the coffee machine has:")
            var milkV = 0
            var waterV = 0
            var coffeeM = 0
            var wantedCups = 0
            try {
                waterV = scanner.nextLine().trim { it <= ' ' }.toInt()
                println("Write how many ml of milk the coffee machine has: ")
                milkV = scanner.nextLine().trim { it <= ' ' }.toInt()
                println("Write how many grams of coffee beans the coffee machine has: ")
                coffeeM = scanner.nextLine().trim { it <= ' ' }.toInt()
                println("Write how many cups of coffee you will need: ")
                wantedCups = scanner.nextLine().trim { it <= ' ' }.toInt()
            } catch (e: IllegalArgumentException) {
                println("please enter a number")
            }
            var cupsAvailable = waterV / 200
            cupsAvailable = cupsAvailable.coerceAtMost(milkV / 50)
            cupsAvailable = cupsAvailable.coerceAtMost(coffeeM / 15)
            if (cupsAvailable == wantedCups) {
                println("Yes, I can make that amount of coffee\n")
            } else if (cupsAvailable < wantedCups) {
                println("No, I can make only $cupsAvailable cup(s) of coffee")
            } else {
                println(
                    "Yes, I can make that amount of coffee (and even " +
                            (cupsAvailable - wantedCups) + " more than that)"
                )
            }
        }
    }
}