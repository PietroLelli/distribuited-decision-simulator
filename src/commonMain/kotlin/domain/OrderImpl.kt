package domain

import domain.interfaces.ConcreteRecipe
import domain.interfaces.Order
import domain.interfaces.Recipe

class OrderImpl(override val idCode: String, override var recipes: List<ConcreteRecipe>, override var priority: Int) : Order {
    override fun addRecipe(recipe: ConcreteRecipe) {
        recipes += recipe
    }

    override fun removeRecipe(recipe: ConcreteRecipe) {
        recipes -= recipe
    }

    override fun modifyPriority(newPriority: Int) {
        priority = newPriority
    }
}