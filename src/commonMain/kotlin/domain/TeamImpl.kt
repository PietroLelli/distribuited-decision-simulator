package domain

import domain.interfaces.Individual
import domain.interfaces.Team

class TeamImpl(
    override val idCode: String,
    override var members: List<Individual>,
    override var underTeams: List<Team>
) : Team {
    override fun addMember(member: Individual) {
        members += member
    }

    override fun removeMember(memberId: String) {
        members = members.filter { it.idCode != memberId }
    }

    override fun addUnderTeam(team: Team) {
        underTeams += team
    }

    override fun removeUnderTeam(teamId: String) {
        underTeams = underTeams.filter { it.idCode != teamId }
    }
}