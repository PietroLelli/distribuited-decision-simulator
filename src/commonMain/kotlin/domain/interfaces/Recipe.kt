package domain.interfaces

interface Recipe {
    val idCode: String
    var activities: List<Activity>
    var dependencies: Map<Activity, List<Activity>>?
    var branches: Map<List<Activity>, List<Activity>>?
    var batches: Map<Activity, Int>?

    fun addActivityAtIndex(activity: Activity, index: Int)
    fun removeActivityAtIndex(index: Int)
    fun removeActivity(idActivity: String)

    fun addDependency(activity: Activity, dependencies: List<Activity>)
    fun removeDependency(activity: Activity, activityToRemove: Activity)

    fun addBranch(branch: Pair<List<Activity>, List<Activity>>)
    fun removeBranch(index: Int)

    fun addBatch(batch: Pair<Activity, Int>)
    fun removeBatch(index: Int)
}