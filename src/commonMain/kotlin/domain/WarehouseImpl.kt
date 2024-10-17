package domain

import domain.interfaces.ByProduct
import domain.interfaces.Product
import domain.interfaces.Resource
import domain.interfaces.Warehouse

class WarehouseImpl(
    override val idCode: String,
    override var products: Map<Product, Int> = mapOf(),
    override var byProducts: Map<ByProduct, Int> = mapOf(),
    override var resources: Map<Resource, Int> = mapOf()
) : Warehouse {
    override fun addProduct(product: Product, quantity: Int) {
        if (products.containsKey(product)) {
            val oldQuantity = products.getValue(product)
            products += Pair(product, oldQuantity + quantity)
        } else {
            products += Pair(product, quantity)
        }
    }

    override fun addByProduct(byProduct: ByProduct, quantity: Int) {
        if (byProducts.containsKey(byProduct)) {
            val oldQuantity = byProducts.getValue(byProduct)
            byProducts += Pair(byProduct, oldQuantity + quantity)
        } else {
            byProducts += Pair(byProduct, quantity)
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
        if (products.containsKey(product)) {
            val oldQuantity = products.getValue(product)
            if (oldQuantity - quantity > 0) {
                products += Pair(product, oldQuantity - quantity)
            } else {
                products -= product
            }
        }
    }

    override fun removeByProduct(byProduct: ByProduct, quantity: Int) {
        if (byProducts.containsKey(byProduct)) {
            val oldQuantity = byProducts.getValue(byProduct)
            if (oldQuantity - quantity > 0) {
                byProducts += Pair(byProduct, oldQuantity - quantity)
            } else {
                byProducts -= byProduct
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