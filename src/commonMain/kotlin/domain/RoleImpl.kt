package domain

import domain.interfaces.Role

class RoleImpl(override val idCode: String, override var responsible: Boolean) : Role {
}