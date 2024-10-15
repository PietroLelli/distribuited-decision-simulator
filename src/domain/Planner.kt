interface Planner {
    val IdCode: String

    fun addRecipe(recipe: Recipe)
    fun removeRecipe(recipe: Recipe)
    fun modifyRecipe(idRecipe: String, newRecipe: Recipe)
    fun addResourceToWarehouse(warehouse: Warehouse, resource: Resource, quantity: Int)
}