package machine

import machine.Machine.start

fun main() {
    val machine = MachineOfCoffee(400, 540, 120, 9, 550)

    var toContinue = true
    while (toContinue) {
        toContinue = start(machine)
    }
}
