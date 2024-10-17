package domain.interfaces

interface OrderGenerator {
    val idCode: String

    fun generateOrder(order: Order)
    fun modifyOrder(idOrder: String, newOrder: Order)
}