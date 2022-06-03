package machine

object Coffee {
    fun calcIngredients(cups: Int) {
        println("For 25 cups of coffee you will need:")
        println((cups * 200).toString() + " ml of water")
        println((cups * 50).toString() + " ml of milk")
        println((cups * 15).toString() + " g of coffee beans")
    }
}