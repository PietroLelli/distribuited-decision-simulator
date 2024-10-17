package domain.interfaces


interface Order {
    val idCode: String
    var recipes: List<ConcreteRecipe>
    var priority: Int

    fun addRecipe(recipe: ConcreteRecipe)
    fun removeRecipe(recipe: ConcreteRecipe)
    fun modifyPriority(newPriority: Int)
}