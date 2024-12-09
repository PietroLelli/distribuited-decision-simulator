import it.unibo.alchemist.Alchemist

/**
 * JVM platform.
 */
actual object Platform {
    /**
     * Platform name.
     */
    actual val name = "JVM"
}

fun main() {
    Alchemist.main(arrayOf("run", "mysim.yml"))
}
