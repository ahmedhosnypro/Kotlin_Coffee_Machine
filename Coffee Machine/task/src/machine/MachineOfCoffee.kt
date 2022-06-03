package machine

class MachineOfCoffee internal constructor(
    var waterV: Int,
    var milkV: Int,
    var coffeeM: Int,
    var disposableCups: Int,
    var storedMoney: Int
) {

    fun canMakeCoffee(coffeeType: CoffeeType): Boolean {
        var canMakeCoffee = true
        if (waterV / coffeeType.waterV < 1) {
            canMakeCoffee = false
            println("Sorry, not enough water!")
        }
        if (coffeeType !== CoffeeType.ESPRESSO && milkV / coffeeType.milkV < 1) {
            canMakeCoffee = false
            println("Sorry, not enough milk!")
        }
        if (coffeeM / coffeeType.coffeeM < 1) {
            canMakeCoffee = false
            println("Sorry, not enough coffee!")
        }
        if (disposableCups < 1) {
            canMakeCoffee = false
            println("Sorry, not enough cups!")
        }
        return canMakeCoffee
    }
}