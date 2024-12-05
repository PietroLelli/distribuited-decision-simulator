import it.unibo.alchemist.Alchemist
import it.unibo.alchemist.model.*

/**
 * JVM platform.
 */
actual object Platform {
    /**
     * Platform name.
     */
    actual val name = "JVM"
}

class ProdUnit(override val node: Node<Any>) : NodeProperty<Any> {
    override fun cloneOnNewNode(node: Node<Any>): NodeProperty<Any> {
        return ProdUnit(node)
    }
}

fun main() {
    Alchemist.main(arrayOf("run", "mysim.yml"))
}
