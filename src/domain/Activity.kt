interface Activity {
    val IdCode: String
    val fixedCost: Double
    val variableCost: Double
    val time: Double
    val priority: Int
    val state: ActivityState
    val productResult: Product
    val byProductResult: ByProduct

    fun execute()

    fun getFixedCost(): Double
    fun getVariableCost(): Double
    fun getTotalCost(): Double
    fun getTime(): Double
    fun getPriority(): Int

    fun setFixedCost(fixedCost: Double)
    fun setVariableCost(variableCost: Double)
    fun setTime(time: Double)
    fun setPriority(priority: Int)
}

enum class ActivityState {
    WAITING,
    LOADING,
    COMPLETE
}