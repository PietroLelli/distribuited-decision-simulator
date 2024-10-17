package domain.interfaces

interface Warehouse {
    val idCode: String
    var products: Map<Product, Int>
    var byProducts: Map<ByProduct, Int>
    var resources: Map<Resource, Int>

    fun addProduct(product: Product, quantity: Int)
    fun addByProduct(byProduct: ByProduct, quantity: Int)
    fun addResource(resource: Resource, quantity: Int)

    fun removeProduct(product: Product, quantity: Int)
    fun removeByProduct(byProduct: ByProduct, quantity: Int)
    fun removeResource(resource: Resource, quantity: Int)
}