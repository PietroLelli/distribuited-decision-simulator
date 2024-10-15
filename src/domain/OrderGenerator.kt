interface OrderGenerator {
    val IdCode: String

    fun generateOrder(order: Order)
    fun modifyOrder(idOrder: String, newOrder: Order)
}