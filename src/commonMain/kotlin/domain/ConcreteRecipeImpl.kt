package domain

import domain.interfaces.Activity
import domain.interfaces.ActivityState
import domain.interfaces.ConcreteRecipe
import domain.interfaces.Recipe

class ConcreteRecipeImpl(
    override val idCode: String, recipe: Recipe,
    override var activities: List<Activity> = recipe.activities.map { cloneActivity(it) }
) : ConcreteRecipe {
    override var dependencies: Map<Activity, List<Activity>>? = recipe.dependencies
    override var branches: Map<List<Activity>, List<Activity>>? = recipe.branches
    override var batches: Map<Activity, Int>? = recipe.batches

    override fun getNextActivityToAssign() : Activity? {
        activities.forEach {
            if (it.state == ActivityState.TOBEASSIGNED) {
                return it
            }
        }
        return null
    }
}

private fun cloneActivity(activity: Activity): Activity {
    return ActivityImpl(
        activity.idCode,
        activity.activityFixedCost,
        activity.activityVariableCost,
        activity.time,
        activity.priority,
        activity.state,
        activity.productResult,
        activity.byProductResult
    )
}