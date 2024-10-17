package domain

import domain.interfaces.*

class ProductionUnitImpl(
    override val idCode: String,
    override var teams: List<Team>
) : ProductionUnit {

    override var waitingList: List<Activity> = emptyList()

    override fun addActivityToWaitingList(activity: Activity) {
        if(activity.state == ActivityState.TOBEASSIGNED)
            waitingList = waitingList + activity
    }

    override fun removeActivityFromWaitingList(activityId: String) {
        waitingList = waitingList.filter { it.idCode != activityId }
    }

    override fun doNextActivityFromWaitingList() : Product?{
        if (waitingList.isNotEmpty()) {
            val nextActivity = waitingList.first()
            waitingList = waitingList.drop(1)
            return doActivity(nextActivity)
        }
        return null
    }

    override fun doActivity(activity: Activity): Product? {
        return activity.execute()
    }

    override fun addTeam(team: Team) {
        teams += team
    }

    override fun removeTeam(teamId: String) {
        teams = teams.filter { it.idCode != teamId }
    }
}