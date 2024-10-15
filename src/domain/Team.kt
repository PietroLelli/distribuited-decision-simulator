interface Team {
    val IdCode: String
    val members: List<Individual>
    val underTeams: List<Team>

    fun addMember(member: Individual)
    fun removeMember(memberId: String)

    fun addUnderTeam(team: Team)
    fun removeUnderTeam(teamId: String)
}