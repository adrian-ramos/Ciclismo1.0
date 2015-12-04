package com.example.ciclismo.team.database;

import com.example.ciclismo.team.data.TeamData;
import com.example.ciclismo.database.DatabaseClauseArg;

import java.util.List;

public interface I_TeamDatabase {

    public TeamData getTeam(Long dataId);
    public TeamData getTeamBy(DatabaseClauseArg[] args);
    public List<TeamData> getTeamListBy(DatabaseClauseArg[] args);
    public List<TeamData> getTeamList();
    public boolean deleteTeam(Long dataId);
    public boolean deleteTeamList();
    public Long saveTeam(TeamData data);
    public boolean updateTeam(TeamData data);

    //public CyclistData getCategory(Long dataId);

}
