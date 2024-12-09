package model

import it.unibo.alchemist.model.Node
import it.unibo.alchemist.model.NodeProperty

class ProdUnit(override val node: Node<Any>) : NodeProperty<Any> {
    override fun cloneOnNewNode(node: Node<Any>): NodeProperty<Any> {
        return ProdUnit(node)
    }
}