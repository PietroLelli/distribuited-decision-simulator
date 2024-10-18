package domain.interfaces

interface ProductionUnit {
    val idCode: String
    var waitingList: List<Activity>
    var teams: List<Team>

    fun addActivityToWaitingList(activity: Activity)
    fun removeActivityFromWaitingList(activityId: String)

    fun doNextActivityFromWaitingList(warehouse: Warehouse)
    fun doActivity(activity: Activity, warehouse: Warehouse)

    fun addTeam(team: Team)
    fun removeTeam(teamId: String)

    fun assignActivityToOtherProductionUnit(activity: Activity, productionUnit: ProductionUnit)

    fun setActivityFixedCost(activity: Activity, cost: Double)
    fun setActivityVariableCost(activity: Activity, cost: Double)
    fun setActivityTime(activity: Activity, time: Double)
}