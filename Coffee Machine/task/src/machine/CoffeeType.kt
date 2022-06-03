package machine

enum class CoffeeType(val waterV: Int, val milkV: Int, val coffeeM: Int, val cost: Int) {
    ESPRESSO(250, 0, 16, 4), LATTE(350, 75, 20, 7), CAPPUCCINO(200, 100, 12, 6),
}