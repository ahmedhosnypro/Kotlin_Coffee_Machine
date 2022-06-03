package machine

enum class CoffeeType(var waterV: Int, var milkV: Int, var coffeeM: Int, var cost: Int) {
    ESPRESSO(250, 0, 16, 4), LATTE(350, 75, 20, 7), CAPPUCCINO(200, 100, 12, 6),
}