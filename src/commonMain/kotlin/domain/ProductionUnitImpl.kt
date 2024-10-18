package domain

import domain.interfaces.*

class ProductionUnitImpl(
    override val idCode: String,
    override var teams: List<Team>
) : ProductionUnit {

    override var waitingList: List<Activity> = emptyList()

    override fun addActivityToWaitingList(activity: Activity) {
        if(activity.state == ActivityState.TOBEASSIGNED) {
            waitingList = waitingList + activity
            activity.state = ActivityState.ASSIGNED
        }
    }

    override fun removeActivityFromWaitingList(activityId: String) {
        waitingList = waitingList.filter { it.idCode != activityId }
    }

    override fun doNextActivityFromWaitingList(warehouse: Warehouse) {
        if (waitingList.isNotEmpty()) {
            val nextActivity = waitingList.first()
            waitingList = waitingList.drop(1)
            doActivity(nextActivity, warehouse)
        }
    }

    override fun doActivity(activity: Activity, warehouse: Warehouse) {
        var enoughResources = true
        val neededResources : MutableMap<Resource, Int> = mutableMapOf()
        activity.requiredResources.forEach { (resource, quantity) ->
            if (warehouse.resources.containsKey(resource) && warehouse.resources[resource]!! >= quantity) {
                neededResources += Pair(resource, quantity)
            }
            else
                enoughResources = false
        }
        if (enoughResources) {
            neededResources.forEach { (resource, quantity) ->
                getResourcesFromWarehouse(warehouse, resource, quantity)
            }
            val product = activity.execute()
            product?.let { warehouse.addProduct(it,1) }
        }
    }

    override fun addTeam(team: Team) {
        teams += team
    }

    override fun removeTeam(teamId: String) {
        teams = teams.filter { it.idCode != teamId }
    }

    override fun assignActivityToOtherProductionUnit(activity: Activity, productionUnit: ProductionUnit) {
        productionUnit.addActivityToWaitingList(activity)
    }

    private fun getResourcesFromWarehouse(warehouse: Warehouse, resource: Resource, quantity: Int) {
        warehouse.removeResource(resource, quantity)
    }
}