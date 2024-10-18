package domain

import domain.interfaces.*

class ActivityImpl(
    override val idCode: String,
    override var activityFixedCost: Double = 0.0,
    override var activityVariableCost: Double = 0.0,
    override var time: Double,
    override var priority: Int,
    override var state: ActivityState,
    override var productResult: Product? = null,
    override var requiredResources: Map<Resource, Int> = mapOf()
): Activity {
    override fun execute(): Product? {
        state = ActivityState.RUNNING
        //wait(time)
        state = ActivityState.COMPLETE
        if (productResult != null)
            return productResult
        return null
    }

    override fun getActivityTotalCost(): Double {
        return activityFixedCost + activityVariableCost
    }
}