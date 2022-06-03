package machine

object Print {
    fun printMachineStatus(machine: MachineOfCoffee) {
        println()
        println("The coffee machine has:")
        println(machine.waterV.toString() + " ml of water")
        println(machine.milkV.toString() + " ml of milk")
        println(machine.coffeeM.toString() + " g of coffee beans")
        println(machine.disposableCups.toString() + " disposable cups")
        println("$" + machine.storedMoney + " of money")
    }
}