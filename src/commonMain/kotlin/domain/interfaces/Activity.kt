package domain.interfaces

interface Activity {
    val idCode: String
    var activityFixedCost: Double
    var activityVariableCost: Double
    var time: Double
    var priority: Int
    var state: ActivityState
    var requiredResources: Map<Resource, Int>
    var productResult: Product?

    fun execute(): Product?
    fun getActivityTotalCost(): Double
}

enum class ActivityState {
    TOBEASSIGNED,
    ASSIGNED,
    RUNNING,
    COMPLETE
}