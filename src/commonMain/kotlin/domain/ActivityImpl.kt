package domain

import domain.interfaces.Activity
import domain.interfaces.ActivityState
import domain.interfaces.ByProduct
import domain.interfaces.Product

class ActivityImpl(
    override val idCode: String,
    override var activityFixedCost: Double = 0.0,
    override var activityVariableCost: Double = 0.0,
    override var time: Double,
    override var priority: Int,
    override var state: ActivityState,
    override var productResult: Product? = null,
    override var byProductResult: ByProduct? = null
): Activity {
    override fun execute(): Product? {
        state = ActivityState.RUNNING
        //wait(time)
        state = ActivityState.COMPLETE
        if (productResult == null && byProductResult != null)
            return byProductResult
        else if (productResult != null && byProductResult == null)
            return productResult
        return null
    }

    override fun getActivityTotalCost(): Double {
        return activityFixedCost + activityVariableCost
    }
}