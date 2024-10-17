package domain.interfaces

interface ConcreteRecipe {
    val idCode: String
    var activities: List<Activity>
    var dependencies: Map<Activity, List<Activity>>?
    var branches: Map<List<Activity>, List<Activity>>?
    var batches: Map<Activity, Int>?

    fun getNextActivityToAssign() : Activity?
}