package domain

import domain.interfaces.*

class WarehouseImpl(
    override val idCode: String,
    override var finalProducts: Map<FinalProduct, Int> = mapOf(),
    override var byProducts: Map<ByProduct, Int> = mapOf(),
    override var resources: Map<Resource, Int> = mapOf()
) : Warehouse {
    override fun addProduct(product: Product, quantity: Int) {
        when (product) {
            is FinalProduct -> {
                if (finalProducts.containsKey(product)) {
                    val oldQuantity = finalProducts.getValue(product)
                    finalProducts += Pair(product, oldQuantity + quantity)
                } else {
                    finalProducts += Pair(product, quantity)
                }
            }
            is ByProduct -> {
                if (byProducts.containsKey(product)) {
                    val oldQuantity = byProducts.getValue(product)
                    byProducts += Pair(product, oldQuantity + quantity)
                } else {
                    byProducts += Pair(product, quantity)
                }
            }
        }
    }

    override fun addResource(resource: Resource, quantity: Int) {
        if (resources.containsKey(resource)) {
            val oldQuantity = resources.getValue(resource)
            resources += Pair(resource, oldQuantity + quantity)
        } else {
            resources += Pair(resource, quantity)
        }
    }

    override fun removeProduct(product: Product, quantity: Int) {
        when (product) {
            is FinalProduct -> {
                if (finalProducts.containsKey(product)) {
                    val oldQuantity = finalProducts.getValue(product)
                    if (oldQuantity - quantity > 0) {
                        finalProducts += Pair(product, oldQuantity - quantity)
                    } else {
                        finalProducts -= product
                    }
                }
            }
            is ByProduct -> {
                if (byProducts.containsKey(product)) {
                    val oldQuantity = byProducts.getValue(product)
                    if (oldQuantity - quantity > 0) {
                        byProducts += Pair(product, oldQuantity - quantity)
                    } else {
                        byProducts -= product
                    }
                }
            }
        }
    }

    override fun removeResource(resource: Resource, quantity: Int) {
        if (resources.containsKey(resource)) {
            val oldQuantity = resources.getValue(resource)
            if (oldQuantity - quantity > 0) {
                resources += Pair(resource, oldQuantity - quantity)
            } else {
                resources -= resource
            }
        }
    }
}