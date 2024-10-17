package domain.interfaces

interface Team {
    val idCode: String
    var members: List<Individual>
    var underTeams: List<Team>

    fun addMember(member: Individual)
    fun removeMember(memberId: String)

    fun addUnderTeam(team: Team)
    fun removeUnderTeam(teamId: String)
}