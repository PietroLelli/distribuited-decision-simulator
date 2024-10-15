interface Recipe {
    val IdCode: String
    val activities: List<Activity>
    val dependencies: List<Pair<Activity, List<Activity>>>
    val branches: List<List<List<Activity>>>
    val batches: List<Pair<Int, Activity>>

    fun addActivityAtIndex(activity: Activity, index: Int)
    fun removeActivityAtIndex(index: Int)
    fun removeActivity(idActivity: String)

    fun addDependency(activity: Activity, dependencies: List<Activity>)
    fun removeDependency(activity: Activity)

    fun addBranch(branch: List<List<Activity>>)
    fun removeBranch(index: Int)

    fun addBatch(batch: Pair<Int, Activity>)
    fun removeBatch(index: Int)
}