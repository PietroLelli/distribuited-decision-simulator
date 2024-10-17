package domain

import domain.interfaces.Planner
import domain.interfaces.Recipe
import domain.interfaces.Resource
import domain.interfaces.Warehouse

class PlannerImpl(override val idCode: String) : Planner {
    override fun addRecipe(recipeList: List<Recipe>, recipe: Recipe): List<Recipe> {
        return recipeList + recipe
    }

    override fun removeRecipe(recipeList: List<Recipe>, recipe: Recipe): List<Recipe> {
        return recipeList.filter { it.idCode != recipe.idCode }
    }
    override fun modifyRecipe(recipeList: List<Recipe>, idRecipe: String, newRecipe: Recipe): List<Recipe> {
        return recipeList.map { if (it.idCode == idRecipe) newRecipe else it }
    }

    override fun addResourceToWarehouse(warehouse: Warehouse, resource: Resource, quantity: Int) {
        warehouse.addResource(resource, quantity)
    }
}