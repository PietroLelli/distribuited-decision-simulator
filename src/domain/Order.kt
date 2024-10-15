interface Order {
    val IdCode: String
    val recipes: List<Recipe>
    val priority: Int

    fun addRecipe(recipe: Recipe)
    fun removeRecipe(recipe: Recipe)
    fun modifyPriority(newPriority: Int)
}