package domain.interfaces

interface Planner {
    val idCode: String

    fun addRecipe(recipeList: List<Recipe>, recipe: Recipe) : List<Recipe>
    fun removeRecipe(recipeList: List<Recipe>, recipe: Recipe) : List<Recipe>
    fun modifyRecipe(recipeList: List<Recipe>, idRecipe: String, newRecipe: Recipe) : List<Recipe>
    fun addResourceToWarehouse(warehouse: Warehouse, resource: Resource, quantity: Int)
}