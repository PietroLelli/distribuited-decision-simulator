package domain.interfaces

interface Warehouse {
    val idCode: String
    var finalProducts: Map<FinalProduct, Int>
    var byProducts: Map<ByProduct, Int>
    var resources: Map<Resource, Int>

    fun addProduct(product: Product, quantity: Int)
    fun addResource(resource: Resource, quantity: Int)

    fun removeProduct(product: Product, quantity: Int)
    fun removeResource(resource: Resource, quantity: Int)
}