import domain.*
import domain.interfaces.*

fun main() {
    val individual1 : Individual = IndividualImpl("Individual1", RoleImpl("1", true))
    val individual2 : Individual = IndividualImpl("Individual2", RoleImpl("2", false))
    val individual3 : Individual = IndividualImpl("Individual3", RoleImpl("3", false))
    val individual4 : Individual = IndividualImpl("Individual4", RoleImpl("4", false))

    val team1 : Team = TeamImpl("Team1", listOf(individual1, individual2), listOf())
    val team2 : Team = TeamImpl("Team2", listOf(individual3), listOf())
    val team3 : Team = TeamImpl("Team3", listOf(individual4), listOf())

    val productionUnit1 : ProductionUnit = ProductionUnitImpl("ProductionUnit1", listOf(team1))
    val productionUnit2 : ProductionUnit = ProductionUnitImpl("ProductionUnit2", listOf(team2))

    val warehouse : Warehouse = WarehouseImpl("Warehouse1")

    val resource1 : Resource = ResourceImpl("Resource1")
    val resource2 : Resource = ResourceImpl("Resource2")
    val planner1 : Planner = PlannerImpl("Planner1")

    fun printProductionUnits() {
        println("ProductionUnit1 teams:")
        productionUnit1.teams.forEach { println("- ${it.idCode}") }
        println("ProductionUnit2 teams:")
        productionUnit2.teams.forEach { println("- ${it.idCode}") }
    }

    println("Initial state:")
    printProductionUnits()

    productionUnit1.addTeam(team3)
    println("\nAdded Team3 to ProductionUnit1")
    printProductionUnits()

    productionUnit1.removeTeam("Team1")
    println("\nRemoved Team1 from ProductionUnit1")
    printProductionUnits()

    productionUnit2.addTeam(team1)
    println("\nAdded Team1 to ProductionUnit2")
    printProductionUnits()

    val product1 : Product = FinalProductImpl("FinalProduct1")
    val product2 : Product = ByProductImpl("ByProduct2")
    val activity1 : Activity = ActivityImpl("Activity1", 1.0, 1.0, 1.0, 1, ActivityState.TOBEASSIGNED, product1, mapOf(resource1 to 1))
    val activity2 : Activity = ActivityImpl("Activity2", 2.0, 2.0, 2.0, 2, ActivityState.TOBEASSIGNED, product2, mapOf(resource2 to 2))
    val recipe1 : Recipe = RecipeImpl("Recipe1", listOf(activity1, activity2))
    val concreteRecipe1 : ConcreteRecipe = ConcreteRecipeImpl("ConcreteRecipe1", recipe1)
    val concreteRecipe2 : ConcreteRecipe = ConcreteRecipeImpl("ConcreteRecipe2", recipe1)
    val order1 : Order = OrderImpl("Order1", listOf(concreteRecipe1, concreteRecipe2), 1)

    fun printOrderStatus(order: Order) {
        println("\nOrdine: ${order.idCode}")
        for (recipe in order.recipes) {
            println("\t- Ricetta: ${recipe.idCode}")
            for (activity in recipe.activities) {
                println("\t\t- ${activity.idCode}: ${activity.state}")
            }
        }
    }

    fun printWarehouseStatus(warehouse: Warehouse) {
        println("\nWarehouse: ${warehouse.idCode}")
        println("Products:")
        for (product in warehouse.finalProducts) {
            println("\t- ${product.key.idCode}: ${product.value}")
        }
        println("ByProducts:")
        for (byProduct in warehouse.byProducts) {
            println("\t- ${byProduct.key.idCode}: ${byProduct.value}")
        }
        println("Resources:")
        for (resource in warehouse.resources) {
            println("\t- ${resource.key.idCode}: ${resource.value}")
        }
    }

    println("\nInitial Warehouse state:")
    printWarehouseStatus(warehouse)
    planner1.addResourceToWarehouse(warehouse, resource1, 5)
    planner1.addResourceToWarehouse(warehouse, resource2, 10)
    println("\nAdd 5 Resource1 to the Warehouse")
    println("\nAdd 10 Resource2 to the Warehouse")
    printWarehouseStatus(warehouse)

    //initial state
    printOrderStatus(order1)
    printWarehouseStatus(warehouse)

    println("\nAssign getNextActivityToAssign from ConcreteRecipe1 at the ProductionUnit1 activityWaitingList.")
    concreteRecipe1.getNextActivityToAssign()?.let { productionUnit1.addActivityToWaitingList(it) }
    println("\nProductionUnit1 doNextActivityFromWaitingList and put the resulting product in the warehouse")
    productionUnit1.doNextActivityFromWaitingList(warehouse)
    printOrderStatus(order1)
    printWarehouseStatus(warehouse)

    println("\nProductionUnit1 assign getNextActivityToAssign from ConcreteRecipe1 at the ProductionUnit2 activityWaitingList.")
    concreteRecipe1.getNextActivityToAssign()?.let { productionUnit1.assignActivityToOtherProductionUnit(it, productionUnit2) }
    println("\nProductionUnit2 doNextActivityFromWaitingList and put the resulting product in the warehouse")
    productionUnit2.doNextActivityFromWaitingList(warehouse)
    printOrderStatus(order1)
    printWarehouseStatus(warehouse)

    println("\nAssign getNextActivityToAssign from ConcreteRecipe2 at the ProductionUnit2 activityWaitingList.")
    concreteRecipe2.getNextActivityToAssign()?.let { productionUnit2.addActivityToWaitingList(it) }
    println("\nProductionUnit2 doNextActivityFromWaitingList and put the resulting product in the warehouse")
    productionUnit2.doNextActivityFromWaitingList(warehouse)
    printOrderStatus(order1)
    printWarehouseStatus(warehouse)

    println("\nAssign getNextActivityToAssign from ConcreteRecipe2 at the ProductionUnit2 activityWaitingList.")
    concreteRecipe2.getNextActivityToAssign()?.let { productionUnit2.addActivityToWaitingList(it) }
    println("\nProductionUnit2 doNextActivityFromWaitingList and put the resulting product in the warehouse")
    productionUnit2.doNextActivityFromWaitingList(warehouse)
    printOrderStatus(order1)
    printWarehouseStatus(warehouse)
}

