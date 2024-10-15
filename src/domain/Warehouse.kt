interface Warehouse {
    val IdCode: String
    val products: List<Pair<Product, Int>>
    val byProduct: List<Pair<ByProduct, Int>>
    val resources: List<Pair<Resource, Int>>

    fun addProduct(product: Product, quantity: Int)
    fun addByProduct(byProduct: ByProduct, quantity: Int)
    fun addResource(resource: Resource, quantity: Int)

    fun removeProduct(product: Product, quantity: Int)
    fun removeByProduct(byProduct: ByProduct, quantity: Int)
    fun removeResource(resource: Resource, quantity: Int)
}