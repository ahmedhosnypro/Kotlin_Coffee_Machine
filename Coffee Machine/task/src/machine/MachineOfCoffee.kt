package machine

class MachineOfCoffee internal constructor(
    waterV: Int, milkV: Int, coffeeM: Int, disposableCups: Int, storedMoney: Int
) {
    var milkV = 0
    var waterV = 0
    var coffeeM = 0
    var disposableCups = 0
    var storedMoney = 0

    init {
        this.waterV = waterV
        this.milkV = milkV
        this.coffeeM = coffeeM
        this.disposableCups = disposableCups
        this.storedMoney = storedMoney
    }

    fun canMakeCoffee(coffeeType: CoffeeType, wantedCups: Int): Boolean {
        var canMakeCoffee = true
        var cupsAvailable: Int
        cupsAvailable = waterV / coffeeType.waterV
        if (coffeeType !== CoffeeType.ESPRESSO) {
            cupsAvailable = cupsAvailable.coerceAtMost(milkV / coffeeType.milkV)
        }
        cupsAvailable = cupsAvailable.coerceAtMost(coffeeM / coffeeType.coffeeM)

        if (cupsAvailable < wantedCups) {
            canMakeCoffee = false
        }
        return canMakeCoffee
    }
}