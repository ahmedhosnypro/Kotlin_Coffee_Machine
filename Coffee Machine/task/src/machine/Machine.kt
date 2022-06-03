package machine

import machine.Print.printMachineStatus
import java.util.*

object Machine {
    private val scanner = Scanner(System.`in`)


    fun start(machine: MachineOfCoffee): Boolean {
        var isContinue = true
        println()
        println("Write action (buy, fill, take, remaining, exit):")
        val inputAction = scanner.nextLine().trim { it <= ' ' }.uppercase(Locale.getDefault())
        var action: Action = Action.BUY
        try {
            action = Action.valueOf(inputAction)
        } catch (e: IllegalArgumentException) {
            println("check input")
        }
        when (action) {
            Action.BUY -> buy(machine)
            Action.FILL -> fill(machine)
            Action.TAKE -> take(machine)
            Action.REMAINING -> printMachineStatus(machine)
            Action.EXIT -> isContinue = false
            else -> {
                // to do
            }
        }
        return isContinue
    }

    private fun buy(machine: MachineOfCoffee) {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
        val input = scanner.nextLine().trim { it <= ' ' }.lowercase(Locale.getDefault())
        if (input == "back") {
            start(machine)
        }
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
        if (machine.canMakeCoffee(coffeeType)) {
            buyCoffee(machine, coffeeType)
            println("I have enough resources, making you a coffee!")
        }
    }

    private fun buyCoffee(machine: MachineOfCoffee, coffeeType: CoffeeType) {
        machine.waterV = machine.waterV - coffeeType.waterV
        machine.milkV = machine.milkV - coffeeType.milkV
        machine.coffeeM = machine.coffeeM - coffeeType.coffeeM
        machine.disposableCups = machine.disposableCups - 1
        machine.storedMoney = machine.storedMoney + coffeeType.cost
    }

    private fun fill(machine: MachineOfCoffee) {
        println("Write how many ml of water you want to add:")
        var waterV = 0
        var milkV = 0
        var coffeeM = 0
        var disposableCups = 0
        try {
            waterV = scanner.nextLine().trim { it <= ' ' }.toInt()
            println("Write how many ml of milk you want to add:")
            milkV = scanner.nextLine().trim { it <= ' ' }.toInt()
            println("Write how many grams of coffee beans you want to add:")
            coffeeM = scanner.nextLine().trim { it <= ' ' }.toInt()
            println("Write how many disposable cups of coffee you want to add:")
            disposableCups = scanner.nextLine().trim { it <= ' ' }.toInt()
        } catch (e: IllegalArgumentException) {
            println("enter a valid value")
        }
        machine.waterV = machine.waterV + waterV
        machine.milkV = machine.milkV + milkV
        machine.coffeeM = machine.coffeeM + coffeeM
        machine.disposableCups = machine.disposableCups + disposableCups
    }

    private fun take(machine: MachineOfCoffee) {
        if (machine.storedMoney > 0) {
            println("I gave you $" + machine.storedMoney)
            machine.storedMoney = 0
        }
    }
}