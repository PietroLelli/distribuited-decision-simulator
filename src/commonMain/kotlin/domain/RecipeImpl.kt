package domain

import domain.interfaces.Activity
import domain.interfaces.Recipe

class RecipeImpl(
    override val idCode: String,
    override var activities: List<Activity>,
    override var dependencies: Map<Activity, List<Activity>>? = null,
    override var branches: Map<List<Activity>, List<Activity>>? = null,
    override var batches: Map<Activity, Int>? = null
) : Recipe {
    override fun addActivityAtIndex(activity: Activity, index: Int) {
        val mutableActivities = activities.toMutableList()
        mutableActivities.add(index, activity)
        activities = mutableActivities
    }

    override fun removeActivityAtIndex(index: Int) {
        val mutableActivities = activities.toMutableList()
        mutableActivities.removeAt(index)
        activities = mutableActivities
    }

    override fun removeActivity(idActivity: String) {
        activities = activities.filter { it.idCode != idActivity }
    }

    override fun addDependency(activity: Activity, dependencies: List<Activity>) {
        this.dependencies = this.dependencies?.plus(Pair(activity, dependencies))
    }

    override fun removeDependency(activity: Activity, activityToRemove: Activity) {
        if (dependencies?.containsKey(activity) == true){
            val list = dependencies!!.getValue(activity).filter { it.idCode != activityToRemove.idCode }
            dependencies = dependencies?.plus(Pair(activity, list))
        }
    }

    override fun addBranch(branch: Pair<List<Activity>, List<Activity>>) {
        branches = branches?.plus(branch)
    }

    override fun removeBranch(index: Int) {
        branches?.filter { it.key != branches!!.keys.elementAt(index)}
    }

    override fun addBatch(batch: Pair<Activity, Int>) {
        batches = batches?.plus(batch)
    }

    override fun removeBatch(index: Int) {
        batches?.filter { it.key != batches!!.keys.elementAt(index)}
    }
}