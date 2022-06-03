package machine

import java.util.*

object Machine {
    private val scanner = Scanner(System.`in`)

    fun start() {
        val machine = MachineOfCoffee(400, 540, 120, 9, 550)
        Print.printMachineStatus(machine)
        println()
        println("Write action (buy, fill, take):")
        val inputAction = scanner.nextLine().trim { it <= ' ' }.uppercase(Locale.getDefault())
        var action: Action = Action.WRONG_ACTION
        try {
            action = Action.valueOf(inputAction)
        } catch (e: IllegalArgumentException) {
            println("check input")
        }
        when (action) {
            Action.BUY -> buy(machine)
            Action.FILL -> fill(machine)
            Action.TAKE -> take(machine)
            else -> {
                // to do
            }
        }
    }

    private fun buy(machine: MachineOfCoffee) {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
        val input = scanner.nextLine().trim { it <= ' ' }.uppercase(Locale.getDefault())
        var option = 0
        try {
            option = input.toInt()
        } catch (e: IllegalArgumentException) {
            println("enter a number")
        }
        when (option) {
            1 -> tryBuyCoffee(machine, CoffeeType.ESPRESSO)
            2 -> tryBuyCoffee(machine, CoffeeType.LATTE)
            3 -> tryBuyCoffee(machine, CoffeeType.CAPPUCCINO)
        }
    }

    private fun tryBuyCoffee(machine: MachineOfCoffee, coffeeType: CoffeeType) {
        val wanted = 1
        if (machine.canMakeCoffee(coffeeType, wanted)) {
            buyCoffee(machine, coffeeType)
            Print.printMachineStatus(machine)
        }
    }

    private fun buyCoffee(machine: MachineOfCoffee, coffeeType: CoffeeType) {
        machine.waterV = machine.waterV - 1 * coffeeType.waterV
        machine.milkV = machine.milkV - 1 * coffeeType.milkV
        machine.coffeeM = machine.coffeeM - 1 * coffeeType.coffeeM
        machine.disposableCups = machine.disposableCups - 1
        machine.storedMoney = machine.storedMoney + 1 * coffeeType.cost
    }


    private fun fill(machine: MachineOfCoffee) {
        println("Write how many ml of water you want to add:")
        var waterV = 0
        var milkV = 0
        var coffeeM = 0
        var cups = 0
        try {
            waterV = scanner.nextLine().trim { it <= ' ' }.toInt()
            println("Write how many ml of milk you want to add:")
            milkV = scanner.nextLine().trim { it <= ' ' }.toInt()
            println("Write how many grams of coffee beans you want to add:")
            coffeeM = scanner.nextLine().trim { it <= ' ' }.toInt()
            println("Write how many disposable cups of coffee you want to add:")
            cups = scanner.nextLine().trim { it <= ' ' }.toInt()
        } catch (e: IllegalArgumentException) {
            println("enter a valid value")
        }
        machine.waterV += waterV
        machine.milkV += milkV
        machine.coffeeM += coffeeM
        machine.disposableCups += cups
        Print.printMachineStatus(machine)
    }

    private fun take(machine: MachineOfCoffee) {
        if (machine.storedMoney > 0) {
            println("I gave you $" + machine.storedMoney)
            machine.storedMoney = 0
            Print.printMachineStatus(machine)
        }
    }
}