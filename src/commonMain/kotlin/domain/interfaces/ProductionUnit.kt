package domain.interfaces

interface ProductionUnit {
    val idCode: String
    var waitingList: List<Activity>
    var teams: List<Team>

    fun addActivityToWaitingList(activity: Activity)
    fun removeActivityFromWaitingList(activityId: String)

    fun doNextActivityFromWaitingList(): Product?
    fun doActivity(activity: Activity): Product?

    fun addTeam(team: Team)
    fun removeTeam(teamId: String)
}