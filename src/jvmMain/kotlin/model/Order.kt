package model

class Order (val idCode: String, var recipes: List<Recipe>, var priority: Int) {
    fun addRecipe(recipe: Recipe) {
        recipes += recipe
    }

    fun removeRecipe(recipe: Recipe) {
        recipes -= recipe
    }

    fun modifyPriority(newPriority: Int) {
        priority = newPriority
    }
}