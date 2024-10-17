package domain

import domain.interfaces.Individual
import domain.interfaces.Role

class IndividualImpl(override val idCode: String, override var role: Role) : Individual {
}