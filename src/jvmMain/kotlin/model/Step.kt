package model

class Step (val idCode: String, var type: StepType) {
    fun execute(){
        println("Executing step $idCode")
    }
}