interface ProductionUnit {
    val IdCode: String
    val waitingList: List<Activity>
    val teams: List<Team>

    fun deleteProductionUnit()
    fun modifyProductionUnit(newProductionUnit: ProductionUnit)

    fun addActivityToWaitingList(activity: Activity)
    fun removeActivityFromWaitingList(activityId: String)

    fun doNextActivityFromWaitingList()
    fun doActivity(activity: Activity)
}